package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.TRole;
import cn.icatw.yeb.server.mapper.TRoleMapper;
import cn.icatw.yeb.server.service.TRoleService;
import org.springframework.stereotype.Service;

/**
 * (TRole)表服务实现类
 *
 * @author icatw
 * @since 2022-05-10 16:54:57
 */
@Service("tRoleService")
public class TRoleServiceImpl extends ServiceImpl<TRoleMapper, TRole> implements TRoleService {
}

