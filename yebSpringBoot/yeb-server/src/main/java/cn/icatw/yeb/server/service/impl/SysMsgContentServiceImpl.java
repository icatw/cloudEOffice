package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.SysMsgContent;
import cn.icatw.yeb.server.mapper.SysMsgContentMapper;
import cn.icatw.yeb.server.service.SysMsgContentService;
import org.springframework.stereotype.Service;

/**
 * (SysMsgContent)表服务实现类
 *
 * @author icatw
 * @since 2022-05-11 16:38:43
 */
@Service("sysMsgContentService")
public class SysMsgContentServiceImpl extends ServiceImpl<SysMsgContentMapper, SysMsgContent> implements SysMsgContentService {
}

