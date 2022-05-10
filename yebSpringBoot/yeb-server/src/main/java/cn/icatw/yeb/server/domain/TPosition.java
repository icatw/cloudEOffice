package cn.icatw.yeb.server.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.*;

import java.io.Serializable;
import java.util.Date;

/**
 * (TPosition)实体类
 *
 * @author icatw
 * @since 2022-05-10 16:54:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("$tableInfo.comment")
public class TPosition implements Serializable {
    private static final long serialVersionUID = 175696770710750166L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 职位
     */
    @TableField(value = "name")
    @ApiModelProperty("职位")
    private String name;

    /**
     * 创建时间
     */
    @TableField(value = "createDate")
    @ApiModelProperty("创建时间")
    private Date createdate;

    /**
     * 是否启用
     */
    @TableField(value = "enabled")
    @ApiModelProperty("是否启用")
    private Integer enabled;
}

