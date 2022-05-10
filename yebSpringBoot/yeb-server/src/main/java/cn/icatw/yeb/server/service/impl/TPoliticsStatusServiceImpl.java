package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.TPoliticsStatus;
import cn.icatw.yeb.server.mapper.TPoliticsStatusMapper;
import cn.icatw.yeb.server.service.TPoliticsStatusService;
import org.springframework.stereotype.Service;

/**
 * (TPoliticsStatus)表服务实现类
 *
 * @author icatw
 * @since 2022-05-10 16:54:56
 */
@Service("tPoliticsStatusService")
public class TPoliticsStatusServiceImpl extends ServiceImpl<TPoliticsStatusMapper, TPoliticsStatus> implements TPoliticsStatusService {
}

