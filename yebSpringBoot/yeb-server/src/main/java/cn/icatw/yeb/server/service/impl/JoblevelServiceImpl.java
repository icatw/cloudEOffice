package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.Joblevel;
import cn.icatw.yeb.server.mapper.JoblevelMapper;
import cn.icatw.yeb.server.service.JoblevelService;
import org.springframework.stereotype.Service;

/**
 * (Joblevel)表服务实现类
 *
 * @author icatw
 * @since 2022-05-11 16:38:37
 */
@Service("joblevelService")
public class JoblevelServiceImpl extends ServiceImpl<JoblevelMapper, Joblevel> implements JoblevelService {
}

