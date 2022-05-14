package cn.icatw.yeb.server.controller;

import cn.icatw.yeb.server.common.R;
import cn.icatw.yeb.server.domain.Salary;
import cn.icatw.yeb.server.service.SalaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * (Salary)表控制层
 *
 * @author icatw
 * @since 2022-05-11 16:38:42
 */
@Api(tags = "工资账套模块")
@RestController
@RequestMapping("/salary/sob")
public class SalaryController {

    /**
     * 服务对象
     */
    @Resource
    private SalaryService salaryService;

    ///**
    // * 分页查询所有数据
    // */
    //@ApiOperation(value = "分页查询所有数据 ")
    //@GetMapping
    //public R page(@RequestParam int current, @RequestParam int size) {
    //    Page<Salary> page = new Page<>(current, size);
    //    return R.ok(this.salaryService.page(page));
    //}

    @ApiOperation(value = "获取所有工资账套")
    @GetMapping("/")
    public List<Salary> getAllSalaries() {
        return salaryService.list();
    }

    /**
     * 通过主键查询单条数据
     */
    @ApiOperation(value = "通过主键查询单条数据 ")
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return R.ok(this.salaryService.getById(id));
    }

    /**
     * 新增数据
     */
    @ApiOperation(value = "新增数据 ")
    @PostMapping
    public R save(@RequestBody Salary salary) {
        salary.setCreatedate(LocalDateTime.now());
        if (this.salaryService.save(salary)) {
            return R.ok("添加成功！", "");
        }
        return R.fail("添加失败！");
    }

    /**
     * 修改数据
     */
    @ApiOperation(value = "修改数据 ")
    @PutMapping
    public R updateById(@RequestBody Salary salary) {
        if (this.salaryService.updateById(salary)) {
            return R.ok("更新成功！", "");
        }
        return R.fail("更新失败！");
    }

    /**
     * 单条删除数据
     */
    @ApiOperation(value = "单条删除数据 ")
    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id) {
        if (this.salaryService.removeById(id)) {
            return R.ok("删除成功！", "");
        }
        return R.fail("删除失败！");
    }
}

