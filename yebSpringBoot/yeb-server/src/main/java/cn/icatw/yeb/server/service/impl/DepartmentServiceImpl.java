package cn.icatw.yeb.server.service.impl;

import cn.icatw.yeb.server.common.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.Department;
import cn.icatw.yeb.server.mapper.DepartmentMapper;
import cn.icatw.yeb.server.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Department)表服务实现类
 *
 * @author icatw
 * @since 2022-05-11 16:38:34
 */
@Service("departmentService")
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {
    @Override
    public List<Department> getAllDepartments() {
        return this.baseMapper.getAllDepartments(-1);
    }

    @Override
    public R addDep(Department department) {
        department.setEnabled(true);
        this.baseMapper.addDep(department);
        if (department.getResult() == 1) {
            return R.ok("添加成功！", department);
        }
        return R.fail("添加失败！");
    }

    @Override
    public R deleteDep(Integer id) {
        Department department = new Department();
        department.setId(id);
        this.baseMapper.deleteDep(department);
        if (-2 == department.getResult()) {
            return R.fail("该部门下有子部门，删除失败！");
        }
        if (-1 == department.getResult()) {
            return R.fail("该部门下有员工，删除失败！");
        }
        if (1 == department.getResult()) {
            return R.ok("删除成功！", "");
        }
        return R.fail("删除失败！");
    }
}

