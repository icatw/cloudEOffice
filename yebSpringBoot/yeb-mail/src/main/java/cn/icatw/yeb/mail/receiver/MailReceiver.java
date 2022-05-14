package cn.icatw.yeb.mail.receiver;

import cn.icatw.yeb.server.common.Constants.MailConstants;
import cn.icatw.yeb.server.domain.Employee;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
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
public class MailReceiver {
    //日志记录，相当于slf4j
    private static final Log LOG = LogFactory.getLog(MailReceiver.class);
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private MailProperties mailProperties;
    @Autowired
    private TemplateEngine templateEngine;

    @RabbitListener(queues = MailConstants.MAIL_QUEUE_NAME)
    public void handler(Employee employee) {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg);
        try {
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
        } catch (MessagingException e) {
            LOG.error("邮件发送失败=====> " + e.getMessage());

        }
    }
}
