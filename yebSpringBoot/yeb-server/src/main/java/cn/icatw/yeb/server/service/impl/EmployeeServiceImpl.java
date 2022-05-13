package cn.icatw.yeb.server.service.impl;

import cn.icatw.yeb.server.common.R;
import cn.icatw.yeb.server.common.RespPageBean;
import cn.icatw.yeb.server.domain.Employee;
import cn.icatw.yeb.server.mapper.EmployeeMapper;
import cn.icatw.yeb.server.service.EmployeeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

/**
 * (Employee)表服务实现类
 *
 * @author icatw
 * @since 2022-05-11 16:38:35
 */
@Service("employeeService")
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    @Override
    public RespPageBean getEmployeeByPage(int current, int size, Employee employee, LocalDate[] beginDateScope) {
        //开启分页
        Page<Employee> page = new Page<>(current, size);
        IPage<Employee> employeePage = this.baseMapper.getEmployeeByPage(page,
                employee, beginDateScope);
        return new
                RespPageBean(employeePage.getTotal(), employeePage.getRecords());

    }

    @Override
    public R insertEmployee(Employee employee) {
        //添加员工时，处理合同期限，保留两位小数
        LocalDate begincontract = employee.getBegincontract();
        LocalDate endcontract = employee.getEndcontract();
        //合同期限：以指定单位计算距离另一个日期的时间量。
        long days = begincontract.until(endcontract, ChronoUnit.DAYS);
        //保留两位小数
        DecimalFormat decimalFormat = new DecimalFormat("##.00");
        //保存合同期限，以年为单位并且保留两位小数
        employee.setContractterm(Double.parseDouble(decimalFormat.format(days / 365.00)));
        return this.baseMapper.insert(employee) == 1 ? R.ok("添加成功！", "") : R.fail("添加失败！");
    }

    @Override
    public R maxWorkId() {
        //SELECT max(workID) FROM t_employee ，查询最大工号
        //查询出来为一个存储hashMap的list，k为查询条件（max(workID)），v为查询结果值
        List<Map<String, Object>> maps = baseMapper.selectMaps
                (new QueryWrapper<Employee>().select("max(workID)"));
        return R.ok(String.format("%08d", Integer.parseInt(maps.get(0).get("max(workID)").toString()) + 1));
    }
}

