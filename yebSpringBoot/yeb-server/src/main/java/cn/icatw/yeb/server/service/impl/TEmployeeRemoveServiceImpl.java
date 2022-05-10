package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.TEmployeeRemove;
import cn.icatw.yeb.server.mapper.TEmployeeRemoveMapper;
import cn.icatw.yeb.server.service.TEmployeeRemoveService;
import org.springframework.stereotype.Service;

/**
 * (TEmployeeRemove)表服务实现类
 *
 * @author icatw
 * @since 2022-05-10 16:54:52
 */
@Service("tEmployeeRemoveService")
public class TEmployeeRemoveServiceImpl extends ServiceImpl<TEmployeeRemoveMapper, TEmployeeRemove> implements TEmployeeRemoveService {
}

