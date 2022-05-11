package cn.icatw.yeb.server.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.*;

import java.io.Serializable;
import java.util.Date;

/**
 * (AdminRole)实体类
 *
 * @author icatw
 * @since 2022-05-11 16:54:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("AdminRole")
public class AdminRole implements Serializable {
    private static final long serialVersionUID = -71240559597695056L;
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

