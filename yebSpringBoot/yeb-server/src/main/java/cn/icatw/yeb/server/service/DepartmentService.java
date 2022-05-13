package cn.icatw.yeb.server.service;

import cn.icatw.yeb.server.common.R;
import cn.icatw.yeb.server.domain.Department;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * (Department)表服务接口
 *
 * @author icatw
 * @since 2022-05-11 16:38:34
 */
public interface DepartmentService extends IService<Department> {
    /**
     * 获取所有部门
     *
     * @return {@link List}<{@link Department}>
     */
    List<Department> getAllDepartments();

    /**
     * 新增部门
     *
     * @param department 部门
     * @return {@link R}
     */
    R addDep(Department department);

    /**
     * 删除部门
     *
     * @param id id
     * @return {@link R}
     */
    R deleteDep(Integer id);
}

