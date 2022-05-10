package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.TEmployeeEc;
import cn.icatw.yeb.server.mapper.TEmployeeEcMapper;
import cn.icatw.yeb.server.service.TEmployeeEcService;
import org.springframework.stereotype.Service;

/**
 * (TEmployeeEc)表服务实现类
 *
 * @author icatw
 * @since 2022-05-10 16:54:51
 */
@Service("tEmployeeEcService")
public class TEmployeeEcServiceImpl extends ServiceImpl<TEmployeeEcMapper, TEmployeeEc> implements TEmployeeEcService {
}

