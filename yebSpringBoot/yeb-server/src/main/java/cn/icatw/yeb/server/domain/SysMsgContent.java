package cn.icatw.yeb.server.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.*;

import java.io.Serializable;
import java.util.Date;

/**
 * (SysMsgContent)实体类
 *
 * @author icatw
 * @since 2022-05-11 16:54:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("SysMsgContent")
public class SysMsgContent implements Serializable {
    private static final long serialVersionUID = 622737371256753532L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    @TableField(value = "title")
    @ApiModelProperty("标题")
    private String title;

    /**
     * 内容
     */
    @TableField(value = "message")
    @ApiModelProperty("内容")
    private String message;

    /**
     * 创建时间
     */
    @TableField(value = "createDate")
    @ApiModelProperty("创建时间")
    private Date createdate;
}

