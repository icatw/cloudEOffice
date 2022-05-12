package cn.icatw.yeb.server.mapper;

import cn.icatw.yeb.server.domain.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Menu)表数据库访问层
 *
 * @author icatw
 * @since 2022-05-11 16:38:38
 */
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 通过用户id查询菜单列表
     *
     * @param id id
     * @return {@link List}<{@link Menu}>
     */
    List<Menu> getMenusByAdminId(@Param("id") Integer id);

    /**
     * 根据角色获取菜单列表
     *
     * @return {@link List}<{@link Menu}>
     */
    List<Menu> getMenusWithRole();

    /**
     * 查询所有菜单
     *
     * @return {@link List}<{@link Menu}>
     */
    List<Menu> getAllMenus();
}

