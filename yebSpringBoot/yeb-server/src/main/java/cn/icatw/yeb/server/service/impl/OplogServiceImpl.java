package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.Oplog;
import cn.icatw.yeb.server.mapper.OplogMapper;
import cn.icatw.yeb.server.service.OplogService;
import org.springframework.stereotype.Service;

/**
 * (Oplog)表服务实现类
 *
 * @author icatw
 * @since 2022-05-11 16:38:39
 */
@Service("oplogService")
public class OplogServiceImpl extends ServiceImpl<OplogMapper, Oplog> implements OplogService {
}

