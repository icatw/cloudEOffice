package cn.icatw.yeb.server.common.exception;

import cn.icatw.yeb.server.common.ResultStatusEnum;
import lombok.Getter;

/**
 * 自定义异常
 * 自定制异常类
 *
 * @author icatw
 * @date 2022/04/28
 */
@Getter
public class CustomException extends RuntimeException {
    private final int code;
    private final String message;

    public CustomException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public CustomException(ResultStatusEnum resultStatusEnum) {
        this.code = resultStatusEnum.getCode();
        this.message = resultStatusEnum.getMessage();
    }
}
