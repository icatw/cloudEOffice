package cn.icatw.yeb.server.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.*;

import java.io.Serializable;
import java.util.Date;

/**
 * (TMenuRole)实体类
 *
 * @author icatw
 * @since 2022-05-10 16:54:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("$tableInfo.comment")
public class TMenuRole implements Serializable {
    private static final long serialVersionUID = 588578925029479307L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 菜单id
     */
    @TableField(value = "mid")
    @ApiModelProperty("菜单id")
    private Integer mid;

    /**
     * 权限id
     */
    @TableField(value = "rid")
    @ApiModelProperty("权限id")
    private Integer rid;
}

