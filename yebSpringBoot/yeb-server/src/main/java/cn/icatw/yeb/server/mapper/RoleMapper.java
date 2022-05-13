package cn.icatw.yeb.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.icatw.yeb.server.domain.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Role)表数据库访问层
 *
 * @author icatw
 * @since 2022-05-11 16:38:41
 */
@Repository
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 根据用户id查询角色列表
     *
     * @param adminId 管理员id
     * @return {@link List}<{@link Role}>
     */
    List<Role> getRoles(@Param("adminId") Integer adminId);
}

