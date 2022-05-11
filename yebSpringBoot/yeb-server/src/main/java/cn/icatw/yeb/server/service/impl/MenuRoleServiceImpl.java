package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.MenuRole;
import cn.icatw.yeb.server.mapper.MenuRoleMapper;
import cn.icatw.yeb.server.service.MenuRoleService;
import org.springframework.stereotype.Service;

/**
 * (MenuRole)表服务实现类
 *
 * @author icatw
 * @since 2022-05-11 16:38:39
 */
@Service("menuRoleService")
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleMapper, MenuRole> implements MenuRoleService {
}

