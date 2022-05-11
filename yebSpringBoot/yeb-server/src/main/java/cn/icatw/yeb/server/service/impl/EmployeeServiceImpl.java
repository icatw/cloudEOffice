package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.Employee;
import cn.icatw.yeb.server.mapper.EmployeeMapper;
import cn.icatw.yeb.server.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * (Employee)表服务实现类
 *
 * @author icatw
 * @since 2022-05-11 16:38:35
 */
@Service("employeeService")
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}

