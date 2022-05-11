package cn.icatw.yeb.server.service;

import cn.icatw.yeb.server.common.R;
import cn.icatw.yeb.server.domain.TAdmin;
import cn.icatw.yeb.server.domain.param.AdminLoginParam;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.http.HttpRequest;

/**
 * (TAdmin)表服务接口
 *
 * @author icatw
 * @since 2022-05-10 16:54:47
 */
public interface TAdminService extends IService<TAdmin> {
    /**
     * 登录
     *
     * @param adminLoginParam 管理员登录参数
     * @param request         请求
     * @return {@link R}
     */
    R login(AdminLoginParam adminLoginParam, HttpRequest request);
}

