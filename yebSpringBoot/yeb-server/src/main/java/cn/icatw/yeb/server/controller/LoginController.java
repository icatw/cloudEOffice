package cn.icatw.yeb.server.controller;

import cn.icatw.yeb.server.common.R;
import cn.icatw.yeb.server.domain.param.AdminLoginParam;
import cn.icatw.yeb.server.service.TAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author icatw
 * @date 2022/5/11
 * @email 762188827@qq.com
 * @apiNote
 */
@Api(tags = "LoginController")
@RestController
public class LoginController {
    @Autowired
    TAdminService adminService;

    @ApiOperation(value = "登录之后返回token")
    @PostMapping("/login")
    public R login(AdminLoginParam adminLoginParam, HttpRequest request) {
        return adminService.login(adminLoginParam, request);
    }
}
