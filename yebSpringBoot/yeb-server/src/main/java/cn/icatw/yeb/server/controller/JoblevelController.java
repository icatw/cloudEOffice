package cn.icatw.yeb.server.controller;

import cn.icatw.yeb.server.common.R;
import cn.icatw.yeb.server.domain.Joblevel;
import cn.icatw.yeb.server.service.JoblevelService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * (Joblevel)表控制层
 *
 * @author icatw
 * @since 2022-05-11 16:38:37
 */
@Api(tags = "职称模块")
@RestController
@RequestMapping("/system/basic/joblevel")
public class JoblevelController {

    /**
     * 服务对象
     */
    @Resource
    private JoblevelService joblevelService;

    ///**
    // * 分页查询所有数据
    // */
    //@ApiOperation(value = "分页查询所有数据 ")
    //@GetMapping
    //public R page(@RequestParam(defaultValue = "1") int current,
    //              @RequestParam(defaultValue = "10") int size) {
    //    Page<Joblevel> page = new Page<>(current, size);
    //    return R.ok(this.joblevelService.page(page));
    //}

    /**
     * 分页查询所有数据
     */
    @ApiOperation(value = "分页查询所有数据 ")
    @GetMapping("/{current}/{size}")
    public R page(@PathVariable int current, @PathVariable int size) {
        Page<Joblevel> getPage = new Page<>(current, size);
        return R.ok(this.joblevelService.page(getPage));
    }

    /**
     * 通过主键查询单条数据
     */
    @ApiOperation(value = "通过主键查询单条数据 ")
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return R.ok(this.joblevelService.getById(id));
    }

    /**
     * 新增数据
     */
    @ApiOperation(value = "新增数据 ")
    @PostMapping
    public R save(@RequestBody Joblevel joblevel) {
        joblevel.setCreatedate(new Date());
        if (this.joblevelService.save(joblevel)) {
            return R.ok("添加成功！", "");
        }
        return R.fail("添加失败！");
    }

    /**
     * 修改数据
     */
    @ApiOperation(value = "修改数据 ")
    @PutMapping
    public R updateById(@RequestBody Joblevel joblevel) {
        if (this.joblevelService.updateById(joblevel)) {
            return R.ok("修改成功！", "");
        }
        return R.fail("修改失败！");
    }

    @ApiOperation(value = "删除职称")
    @DeleteMapping("/{id}")
    public R deleteJobLevel(@PathVariable Integer id) {
        if (joblevelService.removeById(id)) {
            return R.ok("删除成功", "");
        }
        return R.fail("删除失败");
    }

    @ApiOperation(value = "批量删除职称")
    @DeleteMapping("/")
    public R deleteJoblevelByIds(Integer[] ids) {
        if (joblevelService.removeByIds(Arrays.asList(ids))) {
            return R.ok("删除成功", "");
        }
        return R.fail("删除失败");
    }
}

