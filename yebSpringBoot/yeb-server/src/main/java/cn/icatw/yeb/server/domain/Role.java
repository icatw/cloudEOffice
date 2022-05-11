package cn.icatw.yeb.server.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.*;

import java.io.Serializable;
import java.util.Date;

/**
 * (Role)实体类
 *
 * @author icatw
 * @since 2022-05-11 16:54:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Role")
public class Role implements Serializable {
    private static final long serialVersionUID = 215778275557213717L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    @TableField(value = "name")
    @ApiModelProperty("名称")
    private String name;

    /**
     * 角色名称
     */
    @TableField(value = "nameZh")
    @ApiModelProperty("角色名称")
    private String namezh;
}

