package cn.icatw.yeb.server.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.icatw.yeb.server.domain.TSalaryAdjust;
import cn.icatw.yeb.server.service.TSalaryAdjustService;
import cn.icatw.yeb.server.common.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (TSalaryAdjust)表控制层
 *
 * @author icatw
 * @since 2022-05-10 16:54:59
 */
@Api(tags = "(TSalaryAdjust)")
@RestController
@RequestMapping("tSalaryAdjust")
public class TSalaryAdjustController {

    /**
     * 服务对象
     */
    @Resource
    private TSalaryAdjustService tSalaryAdjustService;

    /**
     * 分页查询所有数据
     */
    @ApiOperation(value = "分页查询所有数据 ")
    @GetMapping
    public R page(@RequestParam int current, @RequestParam int size) {
        Page<TSalaryAdjust> page = new Page<>(current, size);
        return R.ok(this.tSalaryAdjustService.page(page));
    }


    /**
     * 通过主键查询单条数据
     */
    @ApiOperation(value = "通过主键查询单条数据 ")
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return R.ok(this.tSalaryAdjustService.getById(id));
    }

    /**
     * 新增数据
     */
    @ApiOperation(value = "新增数据 ")
    @PostMapping
    public R save(@RequestBody TSalaryAdjust tSalaryAdjust) {
        return R.ok(this.tSalaryAdjustService.save(tSalaryAdjust));
    }

    /**
     * 修改数据
     */
    @ApiOperation(value = "修改数据 ")
    @PutMapping
    public R updateById(@RequestBody TSalaryAdjust tSalaryAdjust) {
        return R.ok(this.tSalaryAdjustService.updateById(tSalaryAdjust));
    }

    /**
     * 单条/批量删除数据
     */
    @ApiOperation(value = "单条/批量删除数据 ")
    @DeleteMapping
    public R delete(@RequestParam List<Long> id) {
        return R.ok(this.tSalaryAdjustService.removeByIds(id));
    }
}

