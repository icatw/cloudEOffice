package cn.icatw.yeb.server.service.impl;

import cn.icatw.yeb.server.common.R;
import cn.icatw.yeb.server.domain.param.AdminLoginParam;
import cn.icatw.yeb.server.utils.JwtTokenUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.Admin;
import cn.icatw.yeb.server.mapper.AdminMapper;
import cn.icatw.yeb.server.service.AdminService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * (Admin)表服务实现类
 *
 * @author icatw
 * @since 2022-05-11 16:38:32
 */
@Service("adminService")
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public R login(AdminLoginParam adminLoginParam, HttpServletRequest request) {
        String username = adminLoginParam.getUsername();
        String password = adminLoginParam.getPassword();
        String code = adminLoginParam.getCode();
        HttpSession session = request.getSession();
        //session中的验证码
        String captcha = (String) session.getAttribute("captcha");
        //清除验证码session
        session.removeAttribute("captcha");
        if (!captcha.equalsIgnoreCase(code) || StringUtils.isEmpty(code)) {
            return R.fail("验证码错误，请重新输入！");
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (userDetails == null || !passwordEncoder.matches(password, userDetails.getPassword())) {
            return R.fail("用户名或密码不正确");
        }
        if (!userDetails.isEnabled()) {
            return R.fail("账号被禁用，请联系管理员");
        }

        //更新security登录用户对象
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        String token = jwtTokenUtil.generateToken(userDetails);
        HashMap<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return R.ok("登录成功！", tokenMap);
    }

    @Override
    public Admin getAdminByUserName(String username) {
        return this.getOne(new QueryWrapper<Admin>().eq("username", username)
                .eq("enabled", true));
    }
}
