package cn.icatw.yeb.server.mapper;

import cn.icatw.yeb.server.domain.AdminRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * (AdminRole)表数据库访问层
 *
 * @author icatw
 * @since 2022-05-11 16:38:33
 */
@Repository
public interface AdminRoleMapper extends BaseMapper<AdminRole> {
    /**
     * 添加操作员角色
     *
     * @param adminId 管理员id
     * @param rids    rid
     * @return {@link Integer}
     */
    Integer addRole(@Param("adminId") Integer adminId, @Param("rids") Integer[] rids);
}

