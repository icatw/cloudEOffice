package cn.icatw.yeb.server.common.exception;

import cn.icatw.yeb.server.common.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author icatw
 * @date 2022/4/28
 * @email 762188827@qq.com
 * @apiNote
 */
@RestControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(CustomException.class)
    public R handleCustomException(CustomException customException) {
        return R.fail(customException.getCode(), customException.getMessage());
    }

    @ExceptionHandler(SQLException.class)
    public R sqlException(SQLException e) {
        if (e instanceof SQLIntegrityConstraintViolationException) {
            return R.fail("该数据有关联数据，操作失败！");
        }
        return R.fail("数据库异常，操作失败");
    }
}
