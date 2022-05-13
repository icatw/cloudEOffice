package cn.icatw.yeb.server.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.icatw.yeb.server.common.R;
import cn.icatw.yeb.server.common.RespPageBean;
import cn.icatw.yeb.server.domain.*;
import cn.icatw.yeb.server.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.net.URLEncoder;
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
@RequestMapping("/employee/basic")
public class EmployeeController {

    /**
     * 服务对象
     */
    @Resource
    private EmployeeService employeeService;
    @Autowired
    NationService nationService;
    @Autowired
    PoliticsStatusService politicsStatusService;
    @Autowired
    JoblevelService joblevelService;
    @Autowired
    PositionService positionService;
    @Autowired
    DepartmentService departmentService;

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
    @GetMapping("/{id}")
    public R selectOne(@PathVariable Serializable id) {
        return R.ok(this.employeeService.getById(id));
    }

    /**
     * 新增数据
     */
    @ApiOperation(value = "添加员工 ")
    @PostMapping
    public R save(@RequestBody Employee employee) {
        return employeeService.insertEmployee(employee);
    }

    @ApiOperation(value = "获取所有民族")
    @GetMapping("/nations")
    public List<Nation> getAllNations() {
        return nationService.list();
    }

    @ApiOperation(value = "获取所有政治面貌")
    @GetMapping("/politicsstatus")
    public List<PoliticsStatus> getAllPoliticsStatus() {
        return politicsStatusService.list();
    }

    @ApiOperation(value = "获取所有职称")
    @GetMapping("/joblevels")
    public List<Joblevel> getAllJobLevels() {
        return joblevelService.list();
    }

    @ApiOperation(value = "获取所有职位")
    @GetMapping("/positions")
    public List<Position> getAllPositions() {
        return positionService.list();
    }

    @ApiOperation(value = "获取工号")
    @GetMapping("/maxWorkID")
    public R maxWorkID() {
        return employeeService.maxWorkId();
    }

    @ApiOperation(value = "获取所有部门")
    @GetMapping("/deps")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    /**
     * 修改数据
     */
    @ApiOperation(value = "修改数据 ")
    @PutMapping
    public R updateById(@RequestBody Employee employee) {
        if (this.employeeService.updateById(employee)) {
            return R.ok("更新成功！");
        }
        return R.fail("更新失败！");

    }

    /**
     * 单条/批量删除数据
     */
    @ApiOperation(value = "单条/批量删除数据 ")
    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id) {
        if (this.employeeService.removeById(id)) {
            return R.ok("删除成功！");
        }
        return R.fail("删除失败！");
    }

    //@ApiOperation(value = "导出员工列表Excel",produces = "application/octet-stream")
    //@GetMapping("/export")
    //public void exportUserList(ModelMap map,
    //                           HttpServletRequest request,
    //                           HttpServletResponse response) {
    //    List<Employee> memberList = employeeService.getEmployee(null);
    //    ExportParams params = new ExportParams("员工信息列表", "员工信息列表", ExcelType.XSSF);
    //    map.put(NormalExcelConstants.DATA_LIST, memberList);
    //    map.put(NormalExcelConstants.CLASS, Employee.class);
    //    map.put(NormalExcelConstants.PARAMS, params);
    //    map.put(NormalExcelConstants.FILE_NAME, "员工信息");
    //    PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    //}

    @ApiOperation(value = "导出员工数据")
    @GetMapping(value = "/export", produces = "application/octet-stream")
    public void exportEmployee(HttpServletResponse response) {
        List<Employee> list = employeeService.getEmployee(null);
        ExportParams params = new ExportParams("员工表", "员工表", ExcelType.HSSF);
        Workbook book = ExcelExportUtil.exportExcel(params, Employee.class, list);
        ServletOutputStream out = null;
        try {
            //流形式
            response.setHeader("content-type", "application/octet-stream");
            //防止中文乱码
            response.setHeader("content-disposition", "attachment;filename=" +
                    URLEncoder.encode("员工表.xls", "UTF-8"));
            out = response.getOutputStream();
            book.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != out) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

