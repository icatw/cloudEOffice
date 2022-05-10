package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.TNation;
import cn.icatw.yeb.server.mapper.TNationMapper;
import cn.icatw.yeb.server.service.TNationService;
import org.springframework.stereotype.Service;

/**
 * (TNation)表服务实现类
 *
 * @author icatw
 * @since 2022-05-10 16:54:55
 */
@Service("tNationService")
public class TNationServiceImpl extends ServiceImpl<TNationMapper, TNation> implements TNationService {
}

