package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.EmployeeRemove;
import cn.icatw.yeb.server.mapper.EmployeeRemoveMapper;
import cn.icatw.yeb.server.service.EmployeeRemoveService;
import org.springframework.stereotype.Service;

/**
 * (EmployeeRemove)表服务实现类
 *
 * @author icatw
 * @since 2022-05-11 16:38:36
 */
@Service("employeeRemoveService")
public class EmployeeRemoveServiceImpl extends ServiceImpl<EmployeeRemoveMapper, EmployeeRemove> implements EmployeeRemoveService {
}

