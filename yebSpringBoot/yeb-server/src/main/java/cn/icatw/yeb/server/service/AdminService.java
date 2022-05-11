package cn.icatw.yeb.server.service;

import cn.icatw.yeb.server.common.R;
import cn.icatw.yeb.server.domain.Admin;
import cn.icatw.yeb.server.domain.param.AdminLoginParam;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * (Admin)表服务接口
 *
 * @author icatw
 * @since 2022-05-11 16:38:32
 */
public interface AdminService extends IService<Admin> {
    /**
     * 登录
     *
     * @param adminLoginParam 管理员登录参数
     * @param request         请求
     * @return {@link R}
     */
    R login(AdminLoginParam adminLoginParam, HttpServletRequest request);

    /**
     * 根据用户名得到管理员信息
     *
     * @param username 用户名
     * @return {@link Admin}
     */
    Admin getAdminByUserName(String username);
}

