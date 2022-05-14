package cn.icatw.yeb.server.controller.WebSocket;

import cn.icatw.yeb.server.domain.Admin;
import cn.icatw.yeb.server.domain.ChatMsg.ChatMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

/**
 * @author icatw
 * @date 2022/5/14
 * @email 762188827@qq.com
 * @apiNote
 */
@Controller
public class WsController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/ws/chat")
    public void handleMsg(Authentication authentication, ChatMsg chatMsg) {
        //获取当前登陆用户
        Admin admin = (Admin) authentication.getPrincipal();
        chatMsg.setFrom(admin.getUsername());
        chatMsg.setFromNickName(admin.getName());
        chatMsg.setDate(LocalDateTime.now());
        /*
         * 发送消息
         * 1.消息接收者
         * 2.消息队列
         * 3.消息对象
         */
        simpMessagingTemplate.convertAndSendToUser(chatMsg.getTo(),
                "/queue/chat", chatMsg);
    }
}
