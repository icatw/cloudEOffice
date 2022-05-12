package cn.icatw.yeb.server.service.impl;

import cn.icatw.yeb.server.domain.Admin;
import cn.icatw.yeb.server.domain.Menu;
import cn.icatw.yeb.server.mapper.MenuMapper;
import cn.icatw.yeb.server.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * (Menu)表服务实现类
 *
 * @author icatw
 * @since 2022-05-11 16:38:38
 */
@Service("menuService")
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public List<Menu> getMenusByAdminId() {
        //TODO 修改菜单时需要删除redis再重新添加
        Integer adminId = ((Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        //先从redis中取出redis
        List<Menu> menus = (List<Menu>) ops.get("menu_" + adminId);
        if (CollectionUtils.isEmpty(menus)) {
            menus = this.baseMapper.getMenusByAdminId(adminId);
            //将数据设置到redis中
            ops.set("menu_" + adminId, menus);
        }
        return menus;
    }

    @Override
    public List<Menu> getMenusWithRole() {
        return this.baseMapper.getMenusWithRole();
    }
}

