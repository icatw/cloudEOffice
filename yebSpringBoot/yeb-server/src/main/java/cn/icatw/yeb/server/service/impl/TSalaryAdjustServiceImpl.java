package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.TSalaryAdjust;
import cn.icatw.yeb.server.mapper.TSalaryAdjustMapper;
import cn.icatw.yeb.server.service.TSalaryAdjustService;
import org.springframework.stereotype.Service;

/**
 * (TSalaryAdjust)表服务实现类
 *
 * @author icatw
 * @since 2022-05-10 16:54:59
 */
@Service("tSalaryAdjustService")
public class TSalaryAdjustServiceImpl extends ServiceImpl<TSalaryAdjustMapper, TSalaryAdjust> implements TSalaryAdjustService {
}

