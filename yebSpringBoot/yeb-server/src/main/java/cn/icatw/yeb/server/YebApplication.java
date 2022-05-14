package cn.icatw.yeb.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author icatw
 * @date 2022/5/10
 * @email 762188827@qq.com
 * @apiNote
 */
@SpringBootApplication
@MapperScan("cn.icatw.yeb.server.mapper")
@EnableScheduling
public class YebApplication {
    public static void main(String[] args) {
        SpringApplication.run(YebApplication.class, args);
    }
}
