package cn.icatw.yeb.server.controller;

import cn.icatw.yeb.server.common.R;
import cn.icatw.yeb.server.common.RespPageBean;
import cn.icatw.yeb.server.domain.Employee;
import cn.icatw.yeb.server.domain.Salary;
import cn.icatw.yeb.server.service.EmployeeService;
import cn.icatw.yeb.server.service.SalaryService;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 员工账套控制器
 *
 * @author icatw
 * @date 2022/5/14
 * @email 762188827@qq.com
 * @apiNote
 */
@Api(tags = "员工账套模块")
@RestController
@RequestMapping("/salary/sobcfg")
public class SalarySobCfgController {
    @Autowired
    SalaryService salaryService;
    @Autowired
    EmployeeService employeeService;

    @ApiOperation(value = "获取所有员工账套")
    @GetMapping("/")
    public RespPageBean getEmployeeWithSalary(@RequestParam(defaultValue = "1") Integer current,
                                              @RequestParam(defaultValue = "10") Integer size) {
        return employeeService.getEmployeeWithSalary(current, size);
    }

    @ApiOperation(value = "获取所有工资账套")
    @GetMapping("/salaries")
    public List<Salary> getAllSalaries() {
        return salaryService.list();
    }

    @ApiOperation(value = "更新员工账套")
    @PutMapping("/")
    public R updateEmployeeSalary(Integer eid, Integer sid) {
        if (employeeService.update(new UpdateWrapper<Employee>().set("salaryId",
                sid).eq("id", eid))) {
            return R.ok("更新成功!", "");
        }
        return R.fail("更新失败!");
    }
}
