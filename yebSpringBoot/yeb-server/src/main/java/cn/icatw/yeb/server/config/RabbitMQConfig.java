package cn.icatw.yeb.server.config;

import cn.icatw.yeb.server.common.Constants.MailConstants;
import cn.icatw.yeb.server.domain.MailLog;
import cn.icatw.yeb.server.service.MailLogService;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMq配置类
 *
 * @author icatw
 * @date 2022/5/14
 * @email 762188827@qq.com
 * @apiNote
 */
@Slf4j
@Configuration
public class RabbitMQConfig {
    @Autowired
    private CachingConnectionFactory cachingConnectionFactory;
    @Autowired
    private MailLogService mailLogService;

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);
        /**
         * 消息确认回调，确认消息是否到达broker
         * data：消息唯一标识
         * ack：确认结构
         * cause：失败原因
         */
        rabbitTemplate.setConfirmCallback((data, ack, cause) -> {
            String msgId = data.getId();
            if (ack) {
                //    消息确认成功
                log.info("{}======>消息发送成功", msgId);
                //    更新数据库记录
                mailLogService.update(new UpdateWrapper<MailLog>().set("status", 1).eq("msgId", msgId));
            } else {
                log.info("{}======>消息发送失败", msgId);
            }
        });
        /**
         * 消息失败回调，比如router不到queue时回调
         * msg：消息主题
         * repCode：响应码
         * repText：响应描述
         * exchange：交换机
         * routingKey：路由键
         */
        rabbitTemplate.setReturnsCallback((returnedMessage) -> {
            log.info("{}========消息发送到queue时失败", returnedMessage.getMessage().getBody());
        });
        return rabbitTemplate;
    }

    @Bean
    public Queue queue() {
        return new Queue(MailConstants.MAIL_QUEUE_NAME, true);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(MailConstants.MAIL_EXCHANGE_NAME);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue())
                .to(directExchange())
                .with(MailConstants.MAIL_ROUTING_KEY_NAME);
    }
}
