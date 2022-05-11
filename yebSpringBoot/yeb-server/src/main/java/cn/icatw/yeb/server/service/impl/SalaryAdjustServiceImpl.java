package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.SalaryAdjust;
import cn.icatw.yeb.server.mapper.SalaryAdjustMapper;
import cn.icatw.yeb.server.service.SalaryAdjustService;
import org.springframework.stereotype.Service;

/**
 * (SalaryAdjust)表服务实现类
 *
 * @author icatw
 * @since 2022-05-11 16:38:43
 */
@Service("salaryAdjustService")
public class SalaryAdjustServiceImpl extends ServiceImpl<SalaryAdjustMapper, SalaryAdjust> implements SalaryAdjustService {
}

