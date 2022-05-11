package cn.icatw.yeb.server.service;

import cn.icatw.yeb.server.domain.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * (Menu)表服务接口
 *
 * @author icatw
 * @since 2022-05-11 16:38:38
 */
public interface MenuService extends IService<Menu> {
    /**
     * 通过用户id查询菜单列表
     *
     * @return {@link List}<{@link Menu}>
     */
    List<Menu> getMenusByAdminId();
}

