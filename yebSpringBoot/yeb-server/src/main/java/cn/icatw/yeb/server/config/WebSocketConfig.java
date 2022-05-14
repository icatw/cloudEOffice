package cn.icatw.yeb.server.config;

import cn.icatw.yeb.server.utils.JwtTokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * 网络套接字配置
 *
 * @author icatw
 * @date 2022/5/14
 * @email 762188827@qq.com
 * @apiNote
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Value("{jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        /*
          1.将/ws/ep路径注册为stomp的端点，用户连接了这个端点后就可以进行websocket通讯，支持socketJs
          2.setAllowedOrigins("*") 允许跨域
          3.withSockJS(表示支持socketJS访问)
         */
        registry.addEndpoint("/ws/ep").setAllowedOrigins("*").withSockJS();
    }

    /**
     * 配置消息代理
     *
     * @param registry 注册表
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //配置代理域，可以配置多个，此段代码配置代理目的地的前缀为 /queue，我们就可以在配置的域上向客户端推送消息
        registry.enableSimpleBroker("/queue");
    }

    /**
     * 配置客户端入站通道
     * 输入通道参数设置
     *
     * @param registration 登记
     */
    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(new ChannelInterceptor() {
            @Override
            public Message<?> preSend(Message<?> message, MessageChannel
                    channel) {
                StompHeaderAccessor accessor =
                        MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
                //如果是连接，获取token，设置用户对象
                if (StompCommand.CONNECT.equals(accessor.getCommand())) {
                    String token = accessor.getFirstNativeHeader("Auth-Token");
                    if (!StringUtils.isBlank(token)) {
                        String authToken = token.substring(tokenHead.length());
                        String username =
                                jwtTokenUtil.getUserNameFromToken(authToken);
                        //token中存在用户名
                        if (null != username) {
                            //登录
                            UserDetails userDetails =
                                    userDetailsService.loadUserByUsername(username);
                            //验证token是否有效，重新设置用户对象
                            if (jwtTokenUtil.validateToken(authToken,
                                    userDetails)) {
                                UsernamePasswordAuthenticationToken authentication
                                        = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                                SecurityContextHolder.getContext().setAuthentication(authentication);
                                accessor.setUser(authentication);
                            }
                        }
                    }
                }
                return message;
            }
        });
    }
}
