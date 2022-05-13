package cn.icatw.yeb.server.controller;

import cn.icatw.yeb.server.common.R;
import cn.icatw.yeb.server.domain.Admin;
import cn.icatw.yeb.server.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Admin)表控制层
 *
 * @author icatw
 * @since 2022-05-11 16:38:32
 */
@Api(tags = "操作员")
@RestController
@RequestMapping("/system/admin")
public class AdminController {

    /**
     * 服务对象
     */
    @Resource
    private AdminService adminService;

    /**
     * 分页查询所有数据
     */
    @ApiOperation(value = "获取所有操作员")
    @GetMapping("/")
    public List<Admin> getAllHrs(String keywords) {
        return adminService.getAllAdmins(keywords);
    }


    /**
     * 通过主键查询单条数据
     */
    @ApiOperation(value = "通过主键查询单条数据 ")
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return R.ok(this.adminService.getById(id));
    }

    /**
     * 新增数据
     */
    @ApiOperation(value = "新增数据 ")
    @PostMapping
    public R save(@RequestBody Admin admin) {
        return R.ok(this.adminService.save(admin));
    }

    /**
     * 修改数据
     */
    @ApiOperation(value = "修改数据 ")
    @PutMapping
    public R updateById(@RequestBody Admin admin) {
        if (this.adminService.updateById(admin)) {
            return R.ok("更新成功！", "");
        }
        return R.fail("更新失败！");
    }

    /**
     * 单条/批量删除数据
     */
    @ApiOperation(value = "单条/批量删除数据 ")
    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id) {
        if (this.adminService.removeById(id)) {
            return R.ok("删除成功！", "");
        }
        return R.fail("删除失败！");
    }
}

