package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.MailLog;
import cn.icatw.yeb.server.mapper.MailLogMapper;
import cn.icatw.yeb.server.service.MailLogService;
import org.springframework.stereotype.Service;

/**
 * (MailLog)表服务实现类
 *
 * @author icatw
 * @since 2022-05-11 16:38:38
 */
@Service("mailLogService")
public class MailLogServiceImpl extends ServiceImpl<MailLogMapper, MailLog> implements MailLogService {
}

