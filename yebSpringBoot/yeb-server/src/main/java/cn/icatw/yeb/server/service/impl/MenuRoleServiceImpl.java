package cn.icatw.yeb.server.service.impl;

import cn.icatw.yeb.server.common.R;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.MenuRole;
import cn.icatw.yeb.server.mapper.MenuRoleMapper;
import cn.icatw.yeb.server.service.MenuRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * (MenuRole)表服务实现类
 *
 * @author icatw
 * @since 2022-05-11 16:38:39
 */
@Service("menuRoleService")
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleMapper, MenuRole> implements MenuRoleService {
    @Override
    @Transactional
    public R updateMenuRole(Integer rid, Integer[] mids) {
        //先删除之前的所有角色对应的菜单
        this.baseMapper.delete(new QueryWrapper<MenuRole>().eq("rid", rid));
        if (null == mids || mids.length == 0) {
            //如果传入的菜单id为空的话，直接返回更新成功！
            return R.ok("更新成功！", "");
        }
        Integer result = this.baseMapper.insertRecord(rid, mids);
        if (result == mids.length) {
            return R.ok("更新成功！", "");
        }

        return R.fail("更新失败！");
    }
}

