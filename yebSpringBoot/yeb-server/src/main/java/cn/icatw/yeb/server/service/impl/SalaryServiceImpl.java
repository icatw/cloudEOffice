package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.Salary;
import cn.icatw.yeb.server.mapper.SalaryMapper;
import cn.icatw.yeb.server.service.SalaryService;
import org.springframework.stereotype.Service;

/**
 * (Salary)表服务实现类
 *
 * @author icatw
 * @since 2022-05-11 16:38:42
 */
@Service("salaryService")
public class SalaryServiceImpl extends ServiceImpl<SalaryMapper, Salary> implements SalaryService {
}

