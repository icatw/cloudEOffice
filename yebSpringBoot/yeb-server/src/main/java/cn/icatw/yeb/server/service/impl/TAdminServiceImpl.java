package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.TAdmin;
import cn.icatw.yeb.server.mapper.TAdminMapper;
import cn.icatw.yeb.server.service.TAdminService;
import org.springframework.stereotype.Service;

/**
 * (TAdmin)表服务实现类
 *
 * @author icatw
 * @since 2022-05-10 16:54:47
 */
@Service("tAdminService")
public class TAdminServiceImpl extends ServiceImpl<TAdminMapper, TAdmin> implements TAdminService {
}

