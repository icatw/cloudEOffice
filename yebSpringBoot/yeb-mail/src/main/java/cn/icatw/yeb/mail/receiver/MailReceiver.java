package cn.icatw.yeb.mail.receiver;

import cn.icatw.yeb.server.common.Constants.MailConstants;
import cn.icatw.yeb.server.domain.Employee;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Date;

/**
 * 邮件接收方
 *
 * @author icatw
 * @date 2022/5/14
 * @email 762188827@qq.com
 * @apiNote
 */
@Component
@Slf4j
public class MailReceiver {
    //日志记录，相当于slf4j
    //private static final Log LOG = LogFactory.getLog(MailReceiver.class);
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private MailProperties mailProperties;
    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 处理程序
     * 监听rabbitMq发送来的消息（携带员工信息），进行邮件发送
     *
     * @param message 消息
     * @param channel 通道
     */
    @RabbitListener(queues = MailConstants.MAIL_QUEUE_NAME)
    public void handler(Message<Employee> message, Channel channel) {
        //从消息负载中获取员工信息
        Employee employee = message.getPayload();
        MessageHeaders headers = message.getHeaders();
        //消息序号
        long tag = (long) headers.get(AmqpHeaders.DELIVERY_TAG);
        String msgId = (String) headers.get("spring_returned_message_correlation");
        HashOperations hashOperations = redisTemplate.opsForHash();
        try {
            if (hashOperations.entries("mail_log").containsKey(msgId)) {
                //[d, f, 2, 8, e, 7, 9, 0, -, 9, 8, a, e, -, 4, 3, a, c, -, a, e, f, 1, -, 9, 0, 8, 4, c, 0, 5, 2, 7, 5, 8, 9]
                //    redis中包含key，说明消息已经被消费，手动确认，直接返回
                log.info("消息已经被消费======>{}", msgId);
                /**
                 * 手动确认消息
                 * tag：消息序号
                 * multiple：是否多条
                 */
                channel.basicAck(tag, false);
                return;
            }
            MimeMessage msg = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg);
            //设置邮件相关信息
            //发件人
            helper.setFrom(mailProperties.getUsername());
            //收件人
            helper.setTo(employee.getEmail());
            //    主题
            helper.setSubject("入职欢迎邮件");
            //    发送日期’
            helper.setSentDate(new Date());
            //    邮件内容，将员工信息设置到thymeleaf上下文中
            Context context = new Context();
            context.setVariable("name", employee.getName());
            context.setVariable("posName", employee.getPosition().getName());
            context.setVariable("joblevelName", employee.getJoblevel().getName());
            context.setVariable("departmentName", employee.getDepartment().getName());
            String mail = templateEngine.process("mail", context);
            //将thymeleaf模板内容设置为邮件文本内容
            helper.setText(mail, true);
            javaMailSender.send(msg);
            log.info("邮件发送成功！");
            //    将消息id存入redis
            assert msgId != null;
            hashOperations.put("mail_log", msgId, "OK");
            //    手动确认消息
            channel.basicAck(tag, false);

        } catch (Exception e) {
            try {
                channel.basicNack(tag, false, true);
            } catch (IOException ex) {
                log.error("消息确认失败=====>{}", ex.getMessage());
            }
            log.error("邮件发送失败======>{}", e.getMessage());
        }
    }
}
