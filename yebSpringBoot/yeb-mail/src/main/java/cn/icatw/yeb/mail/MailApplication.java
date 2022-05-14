package cn.icatw.yeb.mail;

import cn.icatw.yeb.server.common.Constants.MailConstants;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author icatw
 * @date 2022/5/14
 * @email 762188827@qq.com
 * @apiNote 邮件服务排除自动数据源配置
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MailApplication {
    public static void main(String[] args) {
        SpringApplication.run(MailApplication.class, args);
    }

    @Bean
    public Queue queue() {
        return new Queue(MailConstants.MAIL_QUEUE_NAME);
    }
}
