package cn.icatw.yeb.server.utils;

import cn.icatw.yeb.server.domain.Admin;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 操作员工具类，获取当前登陆用户信息
 *
 * @author icatw
 * @date 2022/5/13
 * @email 762188827@qq.com
 * @apiNote
 */
public class AdminUtils {
    public static Admin getCurrentAdmin() {
        return (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
