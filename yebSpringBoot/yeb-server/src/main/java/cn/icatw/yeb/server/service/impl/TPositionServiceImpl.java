package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.TPosition;
import cn.icatw.yeb.server.mapper.TPositionMapper;
import cn.icatw.yeb.server.service.TPositionService;
import org.springframework.stereotype.Service;

/**
 * (TPosition)表服务实现类
 *
 * @author icatw
 * @since 2022-05-10 16:54:56
 */
@Service("tPositionService")
public class TPositionServiceImpl extends ServiceImpl<TPositionMapper, TPosition> implements TPositionService {
}

