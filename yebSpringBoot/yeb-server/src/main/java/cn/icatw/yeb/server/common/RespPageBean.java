package cn.icatw.yeb.server.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 通用分页返回结果对象
 *
 * @author icatw
 * @date 2022/05/13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespPageBean {
    private Long total;
    private List<?> data;
}
