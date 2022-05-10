package cn.icatw.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.icatw.yeb.server.domain.TMenu;
import cn.icatw.yeb.server.mapper.TMenuMapper;
import cn.icatw.yeb.server.service.TMenuService;
import org.springframework.stereotype.Service;

/**
 * (TMenu)表服务实现类
 *
 * @author icatw
 * @since 2022-05-10 16:54:54
 */
@Service("tMenuService")
public class TMenuServiceImpl extends ServiceImpl<TMenuMapper, TMenu> implements TMenuService {
}

