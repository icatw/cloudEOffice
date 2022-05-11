package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.AdminRole;
import cn.icatw.yeb.server.mapper.AdminRoleMapper;
import cn.icatw.yeb.server.service.AdminRoleService;
import org.springframework.stereotype.Service;

/**
 * (AdminRole)表服务实现类
 *
 * @author icatw
 * @since 2022-05-11 16:38:33
 */
@Service("adminRoleService")
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole> implements AdminRoleService {
}

