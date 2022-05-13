package cn.icatw.yeb.server.service.impl;

import cn.icatw.yeb.server.common.RespPageBean;
import cn.icatw.yeb.server.domain.Employee;
import cn.icatw.yeb.server.mapper.EmployeeMapper;
import cn.icatw.yeb.server.service.EmployeeService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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
}

