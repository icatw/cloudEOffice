package cn.icatw.yeb.server.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.*;

import java.io.Serializable;
import java.util.Date;

/**
 * (MenuRole)实体类
 *
 * @author icatw
 * @since 2022-05-11 16:54:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("MenuRole")
public class MenuRole implements Serializable {
    private static final long serialVersionUID = -41564437362641723L;
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

