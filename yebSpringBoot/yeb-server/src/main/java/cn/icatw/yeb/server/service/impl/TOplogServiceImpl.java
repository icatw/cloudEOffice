package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.TOplog;
import cn.icatw.yeb.server.mapper.TOplogMapper;
import cn.icatw.yeb.server.service.TOplogService;
import org.springframework.stereotype.Service;

/**
 * (TOplog)表服务实现类
 *
 * @author icatw
 * @since 2022-05-10 16:54:55
 */
@Service("tOplogService")
public class TOplogServiceImpl extends ServiceImpl<TOplogMapper, TOplog> implements TOplogService {
}

