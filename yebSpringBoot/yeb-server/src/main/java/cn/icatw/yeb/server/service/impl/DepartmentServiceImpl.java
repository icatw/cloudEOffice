package cn.icatw.yeb.server.service.impl;

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
}

