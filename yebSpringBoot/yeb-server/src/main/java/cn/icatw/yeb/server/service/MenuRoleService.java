package cn.icatw.yeb.server.service;

import cn.icatw.yeb.server.common.R;
import cn.icatw.yeb.server.domain.MenuRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * (MenuRole)表服务接口
 *
 * @author icatw
 * @since 2022-05-11 16:38:39
 */
public interface MenuRoleService extends IService<MenuRole> {
    /**
     * 更新角色菜单
     *
     * @param rid  掉
     * @param mids mids
     * @return {@link R}
     */
    R updateMenuRole(Integer rid, Integer[] mids);
}

