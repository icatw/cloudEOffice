package cn.icatw.yeb.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.icatw.yeb.server.domain.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Department)表数据库访问层
 *
 * @author icatw
 * @since 2022-05-11 16:38:34
 */
public interface DepartmentMapper extends BaseMapper<Department> {
    /**
     * 获取所有部门
     *
     * @return {@link List}<{@link Department}>
     */
    List<Department> getAllDepartments(@Param("parentId") Integer parentId);
}

