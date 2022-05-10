package cn.icatw.yeb.server.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.icatw.yeb.server.domain.TOplog;
import cn.icatw.yeb.server.service.TOplogService;
import cn.icatw.yeb.server.common.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (TOplog)表控制层
 *
 * @author icatw
 * @since 2022-05-10 16:54:55
 */
@Api(tags = "(TOplog)")
@RestController
@RequestMapping("tOplog")
public class TOplogController {

    /**
     * 服务对象
     */
    @Resource
    private TOplogService tOplogService;

    /**
     * 分页查询所有数据
     */
    @ApiOperation(value = "分页查询所有数据 ")
    @GetMapping
    public R page(@RequestParam int current, @RequestParam int size) {
        Page<TOplog> page = new Page<>(current, size);
        return R.ok(this.tOplogService.page(page));
    }


    /**
     * 通过主键查询单条数据
     */
    @ApiOperation(value = "通过主键查询单条数据 ")
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return R.ok(this.tOplogService.getById(id));
    }

    /**
     * 新增数据
     */
    @ApiOperation(value = "新增数据 ")
    @PostMapping
    public R save(@RequestBody TOplog tOplog) {
        return R.ok(this.tOplogService.save(tOplog));
    }

    /**
     * 修改数据
     */
    @ApiOperation(value = "修改数据 ")
    @PutMapping
    public R updateById(@RequestBody TOplog tOplog) {
        return R.ok(this.tOplogService.updateById(tOplog));
    }

    /**
     * 单条/批量删除数据
     */
    @ApiOperation(value = "单条/批量删除数据 ")
    @DeleteMapping
    public R delete(@RequestParam List<Long> id) {
        return R.ok(this.tOplogService.removeByIds(id));
    }
}

