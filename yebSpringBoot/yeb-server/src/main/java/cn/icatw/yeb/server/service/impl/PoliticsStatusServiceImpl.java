package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.PoliticsStatus;
import cn.icatw.yeb.server.mapper.PoliticsStatusMapper;
import cn.icatw.yeb.server.service.PoliticsStatusService;
import org.springframework.stereotype.Service;

/**
 * (PoliticsStatus)表服务实现类
 *
 * @author icatw
 * @since 2022-05-11 16:38:40
 */
@Service("politicsStatusService")
public class PoliticsStatusServiceImpl extends ServiceImpl<PoliticsStatusMapper, PoliticsStatus> implements PoliticsStatusService {
}

