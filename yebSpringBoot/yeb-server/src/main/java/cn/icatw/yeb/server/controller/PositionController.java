package cn.icatw.yeb.server.controller;

import cn.icatw.yeb.server.common.R;
import cn.icatw.yeb.server.domain.Position;
import cn.icatw.yeb.server.service.PositionService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * (Position)表控制层
 *
 * @author icatw
 * @since 2022-05-11 16:38:40
 */
@Api(tags = "(Position)")
@RestController
@RequestMapping("/system/config/pos")
public class PositionController {

    /**
     * 服务对象
     */
    @Resource
    private PositionService positionService;

    /**
     * 分页查询所有数据
     */
    @ApiOperation(value = "分页查询所有数据 ")
    @GetMapping
    public R page(@RequestParam(defaultValue = "1") int current, @RequestParam(defaultValue = "10") int size) {
        Page<Position> page = new Page<>(current, size);
        return R.ok(this.positionService.page(page));
    }


    /**
     * 通过主键查询单条数据
     */
    @ApiOperation(value = "通过主键查询单条数据 ")
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return R.ok(this.positionService.getById(id));
    }

    /**
     * 新增数据
     */
    @ApiOperation(value = "新增数据 ")
    @PostMapping
    public R save(@RequestBody Position position) {
        position.setCreatedate(LocalDateTime.now());
        if (this.positionService.save(position)) {
            return R.ok("添加成功", null);
        }
        return R.fail("添加失败！");
    }

    /**
     * 修改数据
     */
    @ApiOperation(value = "修改数据 ")
    @PutMapping
    public R updateById(@RequestBody Position position) {
        if (this.positionService.updateById(position)) {
            return R.ok("更新成功！",null);
        }
        return R.fail("更新失败！");
    }

    /**
     * 单条/批量删除数据
     */
    @ApiOperation(value = "单条/批量删除数据 ")
    @DeleteMapping
    public R delete(@RequestParam List<Long> id) {
        //TODO 此处删除操作需要根据前端修改
        if (this.positionService.removeByIds(id)){
            return R.ok("删除成功！",null);
        }
        return R.fail("删除失败！");
    }
}

