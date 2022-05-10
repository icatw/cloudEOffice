package cn.icatw.yeb.server.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.*;

import java.io.Serializable;
import java.util.Date;

/**
 * (TMenu)实体类
 *
 * @author icatw
 * @since 2022-05-10 16:54:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("$tableInfo.comment")
public class TMenu implements Serializable {
    private static final long serialVersionUID = -75068161305703828L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * url
     */
    @TableField(value = "url")
    @ApiModelProperty("url")
    private String url;

    /**
     * path
     */
    @TableField(value = "path")
    @ApiModelProperty("path")
    private String path;

    /**
     * 组件
     */
    @TableField(value = "component")
    @ApiModelProperty("组件")
    private String component;

    /**
     * 菜单名
     */
    @TableField(value = "name")
    @ApiModelProperty("菜单名")
    private String name;

    /**
     * 图标
     */
    @TableField(value = "iconCls")
    @ApiModelProperty("图标")
    private String iconcls;

    /**
     * 是否保持激活
     */
    @TableField(value = "keepAlive")
    @ApiModelProperty("是否保持激活")
    private Integer keepalive;

    /**
     * 是否要求权限
     */
    @TableField(value = "requireAuth")
    @ApiModelProperty("是否要求权限")
    private Integer requireauth;

    /**
     * 父id
     */
    @TableField(value = "parentId")
    @ApiModelProperty("父id")
    private Integer parentid;

    /**
     * 是否启用
     */
    @TableField(value = "enabled")
    @ApiModelProperty("是否启用")
    private Integer enabled;
}

