package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.TJoblevel;
import cn.icatw.yeb.server.mapper.TJoblevelMapper;
import cn.icatw.yeb.server.service.TJoblevelService;
import org.springframework.stereotype.Service;

/**
 * (TJoblevel)表服务实现类
 *
 * @author icatw
 * @since 2022-05-10 16:54:53
 */
@Service("tJoblevelService")
public class TJoblevelServiceImpl extends ServiceImpl<TJoblevelMapper, TJoblevel> implements TJoblevelService {
}

