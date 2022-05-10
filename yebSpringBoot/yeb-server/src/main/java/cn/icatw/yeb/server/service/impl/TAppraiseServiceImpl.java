package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.TAppraise;
import cn.icatw.yeb.server.mapper.TAppraiseMapper;
import cn.icatw.yeb.server.service.TAppraiseService;
import org.springframework.stereotype.Service;

/**
 * (TAppraise)表服务实现类
 *
 * @author icatw
 * @since 2022-05-10 16:54:49
 */
@Service("tAppraiseService")
public class TAppraiseServiceImpl extends ServiceImpl<TAppraiseMapper, TAppraise> implements TAppraiseService {
}

