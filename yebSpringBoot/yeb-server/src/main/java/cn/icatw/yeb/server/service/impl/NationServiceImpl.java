package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.Nation;
import cn.icatw.yeb.server.mapper.NationMapper;
import cn.icatw.yeb.server.service.NationService;
import org.springframework.stereotype.Service;

/**
 * (Nation)表服务实现类
 *
 * @author icatw
 * @since 2022-05-11 16:38:39
 */
@Service("nationService")
public class NationServiceImpl extends ServiceImpl<NationMapper, Nation> implements NationService {
}

