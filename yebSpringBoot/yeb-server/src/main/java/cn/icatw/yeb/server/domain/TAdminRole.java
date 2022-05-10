package cn.icatw.yeb.server.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.*;

import java.io.Serializable;
import java.util.Date;

/**
 * (TAdminRole)实体类
 *
 * @author icatw
 * @since 2022-05-10 16:54:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("$tableInfo.comment")
public class TAdminRole implements Serializable {
    private static final long serialVersionUID = -88974339137204141L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    @TableField(value = "adminId")
    @ApiModelProperty("用户id")
    private Integer adminid;

    /**
     * 权限id
     */
    @TableField(value = "rid")
    @ApiModelProperty("权限id")
    private Integer rid;
}

