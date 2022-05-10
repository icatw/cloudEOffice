package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.TDepartment;
import cn.icatw.yeb.server.mapper.TDepartmentMapper;
import cn.icatw.yeb.server.service.TDepartmentService;
import org.springframework.stereotype.Service;

/**
 * (TDepartment)表服务实现类
 *
 * @author icatw
 * @since 2022-05-10 16:54:49
 */
@Service("tDepartmentService")
public class TDepartmentServiceImpl extends ServiceImpl<TDepartmentMapper, TDepartment> implements TDepartmentService {
}

