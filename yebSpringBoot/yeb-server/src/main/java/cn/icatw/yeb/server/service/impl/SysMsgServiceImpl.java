package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.SysMsg;
import cn.icatw.yeb.server.mapper.SysMsgMapper;
import cn.icatw.yeb.server.service.SysMsgService;
import org.springframework.stereotype.Service;

/**
 * (SysMsg)表服务实现类
 *
 * @author icatw
 * @since 2022-05-11 16:38:43
 */
@Service("sysMsgService")
public class SysMsgServiceImpl extends ServiceImpl<SysMsgMapper, SysMsg> implements SysMsgService {
}

