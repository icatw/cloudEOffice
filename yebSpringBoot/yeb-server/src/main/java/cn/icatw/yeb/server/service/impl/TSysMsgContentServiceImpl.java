package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.TSysMsgContent;
import cn.icatw.yeb.server.mapper.TSysMsgContentMapper;
import cn.icatw.yeb.server.service.TSysMsgContentService;
import org.springframework.stereotype.Service;

/**
 * (TSysMsgContent)表服务实现类
 *
 * @author icatw
 * @since 2022-05-10 16:55:00
 */
@Service("tSysMsgContentService")
public class TSysMsgContentServiceImpl extends ServiceImpl<TSysMsgContentMapper, TSysMsgContent> implements TSysMsgContentService {
}

