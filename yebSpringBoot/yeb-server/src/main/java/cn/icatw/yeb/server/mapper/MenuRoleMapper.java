package cn.icatw.yeb.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.icatw.yeb.server.domain.MenuRole;
import org.apache.ibatis.annotations.Param;

/**
 * (MenuRole)表数据库访问层
 *
 * @author icatw
 * @since 2022-05-11 16:38:39
 */
public interface MenuRoleMapper extends BaseMapper<MenuRole> {
    /**
     * 更新角色菜单
     *
     * @param rid  掉
     * @param mids mids
     * @return {@link Integer}
     */
    Integer insertRecord(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}

