package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.TSysMsg;
import cn.icatw.yeb.server.mapper.TSysMsgMapper;
import cn.icatw.yeb.server.service.TSysMsgService;
import org.springframework.stereotype.Service;

/**
 * (TSysMsg)表服务实现类
 *
 * @author icatw
 * @since 2022-05-10 16:55:00
 */
@Service("tSysMsgService")
public class TSysMsgServiceImpl extends ServiceImpl<TSysMsgMapper, TSysMsg> implements TSysMsgService {
}

