package cn.icatw.yeb.server.service;

import cn.icatw.yeb.server.common.R;
import cn.icatw.yeb.server.common.RespPageBean;
import cn.icatw.yeb.server.domain.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDate;

/**
 * (Employee)表服务接口
 *
 * @author icatw
 * @since 2022-05-11 16:38:35
 */
public interface EmployeeService extends IService<Employee> {
    /**
     * 分页获取所有员工
     *
     * @param current        当前
     * @param size           大小
     * @param employee       员工
     * @param beginDateScope 开始日期范围
     * @return {@link R}
     */
    RespPageBean getEmployeeByPage(int current, int size, Employee employee, LocalDate[] beginDateScope);
}

