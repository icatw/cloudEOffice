package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.TMailLog;
import cn.icatw.yeb.server.mapper.TMailLogMapper;
import cn.icatw.yeb.server.service.TMailLogService;
import org.springframework.stereotype.Service;

/**
 * (TMailLog)表服务实现类
 *
 * @author icatw
 * @since 2022-05-10 16:54:53
 */
@Service("tMailLogService")
public class TMailLogServiceImpl extends ServiceImpl<TMailLogMapper, TMailLog> implements TMailLogService {
}

