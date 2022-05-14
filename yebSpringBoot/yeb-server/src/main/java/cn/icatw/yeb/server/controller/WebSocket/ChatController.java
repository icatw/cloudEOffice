package cn.icatw.yeb.server.controller.WebSocket;

import cn.icatw.yeb.server.domain.Admin;
import cn.icatw.yeb.server.service.AdminService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author icatw
 * @date 2022/5/14
 * @email 762188827@qq.com
 * @apiNote
 */
@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    AdminService adminService;

    @ApiOperation(value = "获取所有操作员")
    @GetMapping("/admin")
    public List<Admin> getAllHrs(String keywords) {
        return adminService.getAllAdmins(keywords);
    }
}
