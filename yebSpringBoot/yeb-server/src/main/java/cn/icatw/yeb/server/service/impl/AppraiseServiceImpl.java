package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.Appraise;
import cn.icatw.yeb.server.mapper.AppraiseMapper;
import cn.icatw.yeb.server.service.AppraiseService;
import org.springframework.stereotype.Service;

/**
 * (Appraise)表服务实现类
 *
 * @author icatw
 * @since 2022-05-11 16:38:33
 */
@Service("appraiseService")
public class AppraiseServiceImpl extends ServiceImpl<AppraiseMapper, Appraise> implements AppraiseService {
}

