package cn.icatw.yeb.server.config;

import cn.icatw.yeb.server.security.JwtAuthenticationTokenFilter;
import cn.icatw.yeb.server.security.RestAccessDeniedHandler;
import cn.icatw.yeb.server.security.RestAuthenticationEntryPoint;
import cn.icatw.yeb.server.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 安全配置
 *
 * @author icatw
 * @date 2022/5/11
 * @email 762188827@qq.com
 * @apiNote
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Lazy
    AdminService adminService;

    @Autowired
    RestAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    RestAccessDeniedHandler accessDeniedHandler;

    private static final String[] URL_WHITELIST = {
            "/login",
            "/logout",
            "/captcha",
            "favicon.ico",
            "/swagger-ui.html/**",
            "/webjars/**",
            "/v2/**",
            "/swagger-resources/**",
            "/doc.html",
            "/upload"
    };

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            return adminService.getAdminByUserName(username);
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationTokenFilter();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //使用jwt，不需要csrf
        http.csrf()
                .disable()
                //基于token不需要session
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                //允许登录访问
                .and()
                .authorizeRequests()
                .antMatchers(URL_WHITELIST)
                .permitAll()
                //除了上面,所有请求都需要认证
                .anyRequest()
                .authenticated()
                //禁用缓存
                .and()
                .headers()
                .cacheControl();
        //    添加jwt登陆授权拦截器，在验证密码的前面添加拦截器
        http.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //    添加自定义未授权和未登录结果返回
        http.exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler)
                .authenticationEntryPoint(authenticationEntryPoint);

    }
}
