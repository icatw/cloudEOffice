package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.TAdminRole;
import cn.icatw.yeb.server.mapper.TAdminRoleMapper;
import cn.icatw.yeb.server.service.TAdminRoleService;
import org.springframework.stereotype.Service;

/**
 * (TAdminRole)表服务实现类
 *
 * @author icatw
 * @since 2022-05-10 16:54:48
 */
@Service("tAdminRoleService")
public class TAdminRoleServiceImpl extends ServiceImpl<TAdminRoleMapper, TAdminRole> implements TAdminRoleService {
}

