package cn.icatw.yeb.server.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.icatw.yeb.server.domain.SysMsgContent;
import cn.icatw.yeb.server.service.SysMsgContentService;
import cn.icatw.yeb.server.common.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (SysMsgContent)表控制层
 *
 * @author icatw
 * @since 2022-05-11 16:38:44
 */
@Api(tags = "(SysMsgContent)")
@RestController
@RequestMapping("sysMsgContent")
public class SysMsgContentController {

    /**
     * 服务对象
     */
    @Resource
    private SysMsgContentService sysMsgContentService;

    /**
     * 分页查询所有数据
     */
    @ApiOperation(value = "分页查询所有数据 ")
    @GetMapping
    public R page(@RequestParam int current, @RequestParam int size) {
        Page<SysMsgContent> page = new Page<>(current, size);
        return R.ok(this.sysMsgContentService.page(page));
    }


    /**
     * 通过主键查询单条数据
     */
    @ApiOperation(value = "通过主键查询单条数据 ")
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return R.ok(this.sysMsgContentService.getById(id));
    }

    /**
     * 新增数据
     */
    @ApiOperation(value = "新增数据 ")
    @PostMapping
    public R save(@RequestBody SysMsgContent sysMsgContent) {
        return R.ok(this.sysMsgContentService.save(sysMsgContent));
    }

    /**
     * 修改数据
     */
    @ApiOperation(value = "修改数据 ")
    @PutMapping
    public R updateById(@RequestBody SysMsgContent sysMsgContent) {
        return R.ok(this.sysMsgContentService.updateById(sysMsgContent));
    }

    /**
     * 单条/批量删除数据
     */
    @ApiOperation(value = "单条/批量删除数据 ")
    @DeleteMapping
    public R delete(@RequestParam List<Long> id) {
        return R.ok(this.sysMsgContentService.removeByIds(id));
    }
}

