package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.TSalary;
import cn.icatw.yeb.server.mapper.TSalaryMapper;
import cn.icatw.yeb.server.service.TSalaryService;
import org.springframework.stereotype.Service;

/**
 * (TSalary)表服务实现类
 *
 * @author icatw
 * @since 2022-05-10 16:54:58
 */
@Service("tSalaryService")
public class TSalaryServiceImpl extends ServiceImpl<TSalaryMapper, TSalary> implements TSalaryService {
}

