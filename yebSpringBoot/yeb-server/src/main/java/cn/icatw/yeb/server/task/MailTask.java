package cn.icatw.yeb.server.task;

import cn.icatw.yeb.server.common.Constants.MailConstants;
import cn.icatw.yeb.server.domain.Employee;
import cn.icatw.yeb.server.domain.MailLog;
import cn.icatw.yeb.server.service.EmployeeService;
import cn.icatw.yeb.server.service.MailLogService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 邮件任务
 * 定时发送之前发送失败的邮件
 *
 * @author icatw
 * @date 2022/5/14
 * @email 762188827@qq.com
 * @apiNote
 */
@Component
public class MailTask {
    @Autowired
    private MailLogService mailLogService;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    EmployeeService employeeService;

    /**
     * 邮件任务
     * 定时十秒钟查询失败的邮件进行重发
     */
    @Scheduled(cron = "0 0 12 * * ?")
    //@Scheduled(cron = "0/10 * * * * ?")
    public void mailTask() {
        //每天十二点定时
        //    邮件状态为0且重试时间小于当前时间的才需要重新发送
        List<MailLog> list = mailLogService.list(new QueryWrapper<MailLog>().eq("status", 0)
                .lt("tryTime", LocalDateTime.now()));
        list.forEach(mailLog -> {
                    //重试次数超过3次，更新为投递失败，不再重试
                    if (mailLog.getCount() >= 3) {
                        mailLogService.update(new UpdateWrapper<MailLog>()
                                .set("status", 2).eq("msgId", mailLog.getMsgid()));
                    }
                    //    更新重试次数，更新时间，重试时间 TODO 此处可能不需要eq msgId
                    mailLogService.update(new UpdateWrapper<MailLog>()
                            .set("count", mailLog.getCount() + 1)
                            .set("updateTime", LocalDateTime.now())
                            .set("tryTime", LocalDateTime.now().plusMinutes(MailConstants.MSG_TIMEOUT))
                            .eq("msgId", mailLog.getMsgid()));
                    //查询邮件对应的员工
                    Employee employee = employeeService.getEmployee(mailLog.getEid()).get(0);
                    //发送消息
                    rabbitTemplate.convertAndSend(MailConstants.MAIL_EXCHANGE_NAME, MailConstants.MAIL_ROUTING_KEY_NAME, employee, new CorrelationData(mailLog.getMsgid()));
                }
        );
    }
}
