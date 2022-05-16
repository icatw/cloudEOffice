package cn.icatw.yeb.server.controller;

import cn.icatw.yeb.server.common.R;
import cn.icatw.yeb.server.domain.Position;
import cn.icatw.yeb.server.service.PositionService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * (Position)表控制层
 *
 * @author icatw
 * @since 2022-05-11 16:38:40
 */
@Api(tags = "职位模块")
@RestController
@RequestMapping("/system/basic/pos")
@Slf4j
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
            return R.ok("添加成功", "");
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
            return R.ok("更新成功！", "");
        }
        return R.fail("更新失败！");
    }

    @ApiOperation("删除职位信息")
    @DeleteMapping("/{id}")
    public R deletePosition(@PathVariable Integer id) {
        if (positionService.removeById(id)) {
            return R.ok("删除成功!", "");
        }
        return R.fail("删除失败!");
    }

    @ApiOperation("批量删除职位信息")
    @DeleteMapping("/")
    public R deletePositionsByIds(Integer[] ids) {
        if (positionService.removeByIds(Arrays.asList(ids))) {
            return R.ok("删除成功!", "");
        }
        return R.fail("删除失败!");
    }
}

