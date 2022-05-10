package cn.icatw.yeb.server.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.icatw.yeb.server.domain.TMailLog;
import cn.icatw.yeb.server.service.TMailLogService;
import cn.icatw.yeb.server.common.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (TMailLog)表控制层
 *
 * @author icatw
 * @since 2022-05-10 16:54:53
 */
@Api(tags = "(TMailLog)")
@RestController
@RequestMapping("tMailLog")
public class TMailLogController {

    /**
     * 服务对象
     */
    @Resource
    private TMailLogService tMailLogService;

    /**
     * 分页查询所有数据
     */
    @ApiOperation(value = "分页查询所有数据 ")
    @GetMapping
    public R page(@RequestParam int current, @RequestParam int size) {
        Page<TMailLog> page = new Page<>(current, size);
        return R.ok(this.tMailLogService.page(page));
    }


    /**
     * 通过主键查询单条数据
     */
    @ApiOperation(value = "通过主键查询单条数据 ")
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return R.ok(this.tMailLogService.getById(id));
    }

    /**
     * 新增数据
     */
    @ApiOperation(value = "新增数据 ")
    @PostMapping
    public R save(@RequestBody TMailLog tMailLog) {
        return R.ok(this.tMailLogService.save(tMailLog));
    }

    /**
     * 修改数据
     */
    @ApiOperation(value = "修改数据 ")
    @PutMapping
    public R updateById(@RequestBody TMailLog tMailLog) {
        return R.ok(this.tMailLogService.updateById(tMailLog));
    }

    /**
     * 单条/批量删除数据
     */
    @ApiOperation(value = "单条/批量删除数据 ")
    @DeleteMapping
    public R delete(@RequestParam List<Long> id) {
        return R.ok(this.tMailLogService.removeByIds(id));
    }
}

