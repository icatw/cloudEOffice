package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.Position;
import cn.icatw.yeb.server.mapper.PositionMapper;
import cn.icatw.yeb.server.service.PositionService;
import org.springframework.stereotype.Service;

/**
 * (Position)表服务实现类
 *
 * @author icatw
 * @since 2022-05-11 16:38:40
 */
@Service("positionService")
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements PositionService {
}

