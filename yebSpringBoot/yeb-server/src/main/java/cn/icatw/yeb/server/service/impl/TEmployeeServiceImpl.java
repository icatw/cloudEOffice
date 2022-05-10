package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.TEmployee;
import cn.icatw.yeb.server.mapper.TEmployeeMapper;
import cn.icatw.yeb.server.service.TEmployeeService;
import org.springframework.stereotype.Service;

/**
 * (TEmployee)表服务实现类
 *
 * @author icatw
 * @since 2022-05-10 16:54:50
 */
@Service("tEmployeeService")
public class TEmployeeServiceImpl extends ServiceImpl<TEmployeeMapper, TEmployee> implements TEmployeeService {
}

