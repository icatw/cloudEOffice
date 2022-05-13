package cn.icatw.yeb.server.controller;

import cn.icatw.yeb.server.common.R;
import cn.icatw.yeb.server.common.RespPageBean;
import cn.icatw.yeb.server.domain.Employee;
import cn.icatw.yeb.server.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * (Employee)表控制层
 *
 * @author icatw
 * @since 2022-05-11 16:38:35
 */
@Api(tags = "员工")
@RestController
@RequestMapping("employee")
public class EmployeeController {

    /**
     * 服务对象
     */
    @Resource
    private EmployeeService employeeService;

    /**
     * 分页查询所有数据
     */
    @ApiOperation(value = "分页查询所有数据 ")
    @GetMapping
    public RespPageBean page(@RequestParam(defaultValue = "1") int current,
                             @RequestParam(defaultValue = "10") int size,
                             Employee employee, LocalDate[] beginDateScope) {
        return employeeService.getEmployeeByPage(current, size, employee, beginDateScope);
        //Page<Employee> page = new Page<>(current, size);
        //return R.ok(this.employeeService.page(page));
    }


    /**
     * 通过主键查询单条数据
     */
    @ApiOperation(value = "通过主键查询单条数据 ")
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return R.ok(this.employeeService.getById(id));
    }

    /**
     * 新增数据
     */
    @ApiOperation(value = "新增数据 ")
    @PostMapping
    public R save(@RequestBody Employee employee) {
        return R.ok(this.employeeService.save(employee));
    }

    /**
     * 修改数据
     */
    @ApiOperation(value = "修改数据 ")
    @PutMapping
    public R updateById(@RequestBody Employee employee) {
        return R.ok(this.employeeService.updateById(employee));
    }

    /**
     * 单条/批量删除数据
     */
    @ApiOperation(value = "单条/批量删除数据 ")
    @DeleteMapping
    public R delete(@RequestParam List<Long> id) {
        return R.ok(this.employeeService.removeByIds(id));
    }
}

