package cn.icatw.yeb.server.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.icatw.yeb.server.domain.TMenu;
import cn.icatw.yeb.server.service.TMenuService;
import cn.icatw.yeb.server.common.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (TMenu)表控制层
 *
 * @author icatw
 * @since 2022-05-10 16:54:54
 */
@Api(tags = "(TMenu)")
@RestController
@RequestMapping("tMenu")
public class TMenuController {

    /**
     * 服务对象
     */
    @Resource
    private TMenuService tMenuService;

    /**
     * 分页查询所有数据
     */
    @ApiOperation(value = "分页查询所有数据 ")
    @GetMapping
    public R page(@RequestParam int current, @RequestParam int size) {
        Page<TMenu> page = new Page<>(current, size);
        return R.ok(this.tMenuService.page(page));
    }


    /**
     * 通过主键查询单条数据
     */
    @ApiOperation(value = "通过主键查询单条数据 ")
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return R.ok(this.tMenuService.getById(id));
    }

    /**
     * 新增数据
     */
    @ApiOperation(value = "新增数据 ")
    @PostMapping
    public R save(@RequestBody TMenu tMenu) {
        return R.ok(this.tMenuService.save(tMenu));
    }

    /**
     * 修改数据
     */
    @ApiOperation(value = "修改数据 ")
    @PutMapping
    public R updateById(@RequestBody TMenu tMenu) {
        return R.ok(this.tMenuService.updateById(tMenu));
    }

    /**
     * 单条/批量删除数据
     */
    @ApiOperation(value = "单条/批量删除数据 ")
    @DeleteMapping
    public R delete(@RequestParam List<Long> id) {
        return R.ok(this.tMenuService.removeByIds(id));
    }
}

