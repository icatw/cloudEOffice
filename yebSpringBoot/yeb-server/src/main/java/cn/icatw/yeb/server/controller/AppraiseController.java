package cn.icatw.yeb.server.controller;

import cn.icatw.yeb.server.common.R;
import cn.icatw.yeb.server.domain.Appraise;
import cn.icatw.yeb.server.service.AppraiseService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Appraise)表控制层
 *
 * @author icatw
 * @since 2022-05-11 16:38:33
 */
@Api(tags = "评价模块")
@RestController
@RequestMapping("appraise")
public class AppraiseController {

    /**
     * 服务对象
     */
    @Resource
    private AppraiseService appraiseService;

    /**
     * 分页查询所有数据
     */
    @ApiOperation(value = "分页查询所有数据 ")
    @GetMapping
    public R page(@RequestParam int current, @RequestParam int size) {
        Page<Appraise> page = new Page<>(current, size);
        return R.ok(this.appraiseService.page(page));
    }


    /**
     * 通过主键查询单条数据
     */
    @ApiOperation(value = "通过主键查询单条数据 ")
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return R.ok(this.appraiseService.getById(id));
    }

    /**
     * 新增数据
     */
    @ApiOperation(value = "新增数据 ")
    @PostMapping
    public R save(@RequestBody Appraise appraise) {
        return R.ok(this.appraiseService.save(appraise));
    }

    /**
     * 修改数据
     */
    @ApiOperation(value = "修改数据 ")
    @PutMapping
    public R updateById(@RequestBody Appraise appraise) {
        return R.ok(this.appraiseService.updateById(appraise));
    }

    /**
     * 单条/批量删除数据
     */
    @ApiOperation(value = "单条/批量删除数据 ")
    @DeleteMapping
    public R delete(@RequestParam List<Long> id) {
        return R.ok(this.appraiseService.removeByIds(id));
    }
}

