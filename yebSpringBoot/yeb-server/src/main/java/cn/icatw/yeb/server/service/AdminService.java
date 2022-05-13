package cn.icatw.yeb.server.service;

import cn.icatw.yeb.server.common.R;
import cn.icatw.yeb.server.domain.Admin;
import cn.icatw.yeb.server.domain.Role;
import cn.icatw.yeb.server.domain.param.AdminLoginParam;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    /**
     * 根据用户id查询角色
     *
     * @param adminId 管理员id
     * @return {@link List}<{@link Role}>
     */
    List<Role> getRoles(Integer adminId);

    /**
     * 模糊查询除了当前登陆的操作员之外的其他所有管理员信息（包含对应的角色信息）
     * 当前登陆的操作员会有专门的个人信息展示，因此排除查询
     *
     * @param keywords 关键字
     * @return {@link List}<{@link Admin}>
     */
    List<Admin> getAllAdmins(String keywords);
}

