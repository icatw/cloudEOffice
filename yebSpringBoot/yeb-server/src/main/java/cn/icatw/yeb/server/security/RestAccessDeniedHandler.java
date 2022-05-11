package cn.icatw.yeb.server.security;

import cn.icatw.yeb.server.common.R;
import cn.icatw.yeb.server.common.ResultStatusEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 其他拒绝访问处理程序，权限不足时，自定义返回结果
 *
 * @author icatw
 * @date 2022/5/11
 * @email 762188827@qq.com
 * @apiNote
 */
@Component
public class RestAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        //R r = R.fail("权限不足，请联系管理员");

        R r = R.fail(ResultStatusEnum.PERMISSION_NOT_EXCEPTION);
        writer.write(new ObjectMapper().writeValueAsString(r));
        writer.flush();
        writer.close();
    }
}
