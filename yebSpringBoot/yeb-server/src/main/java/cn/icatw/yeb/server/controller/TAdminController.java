package cn.icatw.yeb.server.controller;

import cn.icatw.yeb.server.common.R;
import cn.icatw.yeb.server.domain.TAdmin;
import cn.icatw.yeb.server.service.TAdminService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (TAdmin)表控制层
 *
 * @author icatw
 * @since 2022-05-10 16:54:47
 */
@Api(tags = "(TAdmin)")
@RestController
@RequestMapping("tAdmin")
public class TAdminController {

    /**
     * 服务对象
     */
    @Resource
    private TAdminService tAdminService;

    /**
     * 分页查询所有数据
     */
    @ApiOperation(value = "分页查询所有数据 ")
    @GetMapping
    public R page(@RequestParam int current, @RequestParam int size) {
        Page<TAdmin> page = new Page<>(current, size);
        return R.ok(this.tAdminService.page(page));
    }


    /**
     * 通过主键查询单条数据
     */
    @ApiOperation(value = "通过主键查询单条数据 ")
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return R.ok(this.tAdminService.getById(id));
    }

    /**
     * 新增数据
     */
    @ApiOperation(value = "新增数据 ")
    @PostMapping
    public R save(@RequestBody TAdmin tAdmin) {
        return R.ok(this.tAdminService.save(tAdmin));
    }

    /**
     * 修改数据
     */
    @ApiOperation(value = "修改数据 ")
    @PutMapping
    public R updateById(@RequestBody TAdmin tAdmin) {
        return R.ok(this.tAdminService.updateById(tAdmin));
    }

    /**
     * 单条/批量删除数据
     */
    @ApiOperation(value = "单条/批量删除数据 ")
    @DeleteMapping
    public R delete(@RequestParam List<Long> id) {
        return R.ok(this.tAdminService.removeByIds(id));
    }
}

