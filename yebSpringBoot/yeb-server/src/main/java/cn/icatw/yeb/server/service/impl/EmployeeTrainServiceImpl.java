package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.EmployeeTrain;
import cn.icatw.yeb.server.mapper.EmployeeTrainMapper;
import cn.icatw.yeb.server.service.EmployeeTrainService;
import org.springframework.stereotype.Service;

/**
 * (EmployeeTrain)表服务实现类
 *
 * @author icatw
 * @since 2022-05-11 16:38:37
 */
@Service("employeeTrainService")
public class EmployeeTrainServiceImpl extends ServiceImpl<EmployeeTrainMapper, EmployeeTrain> implements EmployeeTrainService {
}

