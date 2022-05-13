package cn.icatw.yeb.server.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.icatw.yeb.server.common.R;
import cn.icatw.yeb.server.common.RespPageBean;
import cn.icatw.yeb.server.domain.*;
import cn.icatw.yeb.server.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    /**
     * 导入员工
     * 重写equals和hashCode方法
     * 导入时，我们需要获取到对应的民族id，政治面貌id，职称id，职位id等。有两种方法
     * 1. 根据name属性的值去数据库查询对应的id，显然在循环里面不断去查询数据库非常消耗性能，不
     * 推荐
     * 2. 重写equals和hashCode方法，只要name属性的值一致就表示对象一致。前提是name属性的值
     * 基本不会变动
     * 我们选择第二种方法实现
     *
     * @param file 文件
     * @return {@link R}
     */
    @ApiOperation(value = "导入员工数据")
    @ApiImplicitParams({@ApiImplicitParam(name = "file", value = "上传文件", dataType = "MultipartFile")})
    @PostMapping("/import")
    public R importEmployee(MultipartFile file) {
        //导入参数
        ImportParams params = new ImportParams();
        //去掉标题行
        params.setTitleRows(1);
        params.setHeadRows(1);
        //民族
        List<Nation> nationList = nationService.list();
        //政治状况
        List<PoliticsStatus> politicsStatusList = politicsStatusService.list();
        //部门
        List<Department> departmentList = departmentService.list();
        //职称
        List<Joblevel> joblevelList = joblevelService.list();
        //职位
        List<Position> positionList = positionService.list();
        try {
            //通过导入的Excel读取到员工实体类列表信息
            List<Employee> list = ExcelImportUtil.importExcel(file.getInputStream(), Employee.class, params);
            //再通过list遍历导入数据库
            list.forEach(employee -> {
                //因为我们重写equals和hashCode方法，只要name属性的值一致就表示对象一致。前提是name属性的值基本不会变动
                //将对应的民族id、政治面貌id、部门id、以及职称和职位id设置为：
                // 数据库里面查出来的list的 Excel中的对象值名字的id
                //数据库查出来的list再获得前端传入的Excel字段名对应的名字的索引（此处将主键id作为索引，当id不连续时可能会出现异常）
                //    民族id
                //TODO 因为此处将id作为索引查询list，所以当id不连续时可能会出现异常
                employee.setNationid(nationList.get(nationList.indexOf
                        (new Nation(employee.getNation().getName()))).getId());
                //    政治面貌id
                employee.setPoliticid(politicsStatusList.get(politicsStatusList.indexOf
                        (new PoliticsStatus(employee.getPoliticsStatus().getName()))).getId());
                //    部门id
                employee.setDepartmentid(departmentList.get(departmentList.indexOf
                        (new Department(employee.getDepartment().getName()))).getId());
                //    职称id
                employee.setJoblevelid(joblevelList.get(joblevelList.indexOf
                        (new Joblevel(employee.getJoblevel().getName()))).getId());
                //    职位id
                employee.setPosid(positionList.get(positionList.indexOf
                        (new Position(employee.getPosition().getName()))).getId());
            });
            if (employeeService.saveBatch(list)) {
                return R.ok("导入成功！", "");
            }
            return R.fail("导入失败");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.fail("导入失败");
    }
}

