package cn.icatw.yeb.server.service.impl;

import cn.icatw.yeb.server.domain.Admin;
import cn.icatw.yeb.server.domain.Menu;
import cn.icatw.yeb.server.mapper.MenuMapper;
import cn.icatw.yeb.server.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Menu)表服务实现类
 *
 * @author icatw
 * @since 2022-05-11 16:38:38
 */
@Service("menuService")
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {


    @Override
    public List<Menu> getMenusByAdminId() {
        return this.baseMapper.getMenusByAdminId(((Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }
}

