package cn.icatw.yeb.server.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.*;

import java.io.Serializable;
import java.util.Date;

/**
 * (TNation)实体类
 *
 * @author icatw
 * @since 2022-05-10 16:54:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("$tableInfo.comment")
public class TNation implements Serializable {
    private static final long serialVersionUID = -49859474492823146L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 民族
     */
    @TableField(value = "name")
    @ApiModelProperty("民族")
    private String name;
}

