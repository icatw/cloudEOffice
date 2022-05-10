package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.TEmployeeTrain;
import cn.icatw.yeb.server.mapper.TEmployeeTrainMapper;
import cn.icatw.yeb.server.service.TEmployeeTrainService;
import org.springframework.stereotype.Service;

/**
 * (TEmployeeTrain)表服务实现类
 *
 * @author icatw
 * @since 2022-05-10 16:54:52
 */
@Service("tEmployeeTrainService")
public class TEmployeeTrainServiceImpl extends ServiceImpl<TEmployeeTrainMapper, TEmployeeTrain> implements TEmployeeTrainService {
}

