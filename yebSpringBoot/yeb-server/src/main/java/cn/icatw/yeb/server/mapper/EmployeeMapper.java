package cn.icatw.yeb.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.icatw.yeb.server.domain.Employee;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * (Employee)表数据库访问层
 *
 * @author icatw
 * @since 2022-05-11 16:38:35
 */
public interface EmployeeMapper extends BaseMapper<Employee> {
    /**
     * 分页查询所有员工
     *
     * @param page           页面
     * @param employee       员工
     * @param beginDateScope 开始日期范围
     * @return {@link IPage}<{@link Employee}>
     */
    IPage<Employee> getEmployeeByPage(@Param("page") Page<Employee> page,
                                      @Param("employee") Employee employee,
                                      @Param("beginDateScope") LocalDate[] beginDateScope);

    /**
     * 查询员工
     *
     * @param id id
     * @return {@link List}<{@link Employee}>
     */
    List<Employee> getEmployee(@Param("id") Integer id);

    /**
     * 获取所有员工账套
     *
     * @param page 页面
     * @return {@link IPage}<{@link Employee}>
     */
    IPage<Employee> getEmployeeWithSalary(Page<Employee> page);
}

