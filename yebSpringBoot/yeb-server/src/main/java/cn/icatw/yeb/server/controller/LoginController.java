package cn.icatw.yeb.server.controller;

import cn.icatw.yeb.server.common.R;
import cn.icatw.yeb.server.domain.Admin;
import cn.icatw.yeb.server.domain.param.AdminLoginParam;
import cn.icatw.yeb.server.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * @author icatw
 * @date 2022/5/11
 * @email 762188827@qq.com
 * @apiNote
 */
@Api(tags = "登陆模块")
@RestController
public class LoginController {
    @Autowired
    AdminService adminService;

    @ApiOperation(value = "登录之后返回token")
    @PostMapping("/login")
    public R login(@RequestBody AdminLoginParam adminLoginParam, HttpServletRequest request) {
        return adminService.login(adminLoginParam, request);
    }

    @ApiOperation(value = "获取当前登陆用户的信息")
    @GetMapping("/admin/info")
    public Admin getAdminInfo(Principal principal) {
        if (principal == null) {
            return null;
        }
        String username = principal.getName();
        Admin admin = adminService.getAdminByUserName(username);
        admin.setRoles(adminService.getRoles(admin.getId()));
        return admin;
    }

    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    public R logOut() {
        return R.ok("注销成功！", null);
    }

}
