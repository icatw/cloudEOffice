package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.TMenuRole;
import cn.icatw.yeb.server.mapper.TMenuRoleMapper;
import cn.icatw.yeb.server.service.TMenuRoleService;
import org.springframework.stereotype.Service;

/**
 * (TMenuRole)表服务实现类
 *
 * @author icatw
 * @since 2022-05-10 16:54:54
 */
@Service("tMenuRoleService")
public class TMenuRoleServiceImpl extends ServiceImpl<TMenuRoleMapper, TMenuRole> implements TMenuRoleService {
}

