package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.EmployeeEc;
import cn.icatw.yeb.server.mapper.EmployeeEcMapper;
import cn.icatw.yeb.server.service.EmployeeEcService;
import org.springframework.stereotype.Service;

/**
 * (EmployeeEc)表服务实现类
 *
 * @author icatw
 * @since 2022-05-11 16:38:36
 */
@Service("employeeEcService")
public class EmployeeEcServiceImpl extends ServiceImpl<EmployeeEcMapper, EmployeeEc> implements EmployeeEcService {
}

