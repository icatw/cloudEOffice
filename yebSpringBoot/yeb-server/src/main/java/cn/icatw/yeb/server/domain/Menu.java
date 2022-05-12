package cn.icatw.yeb.server.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * (Menu)实体类
 *
 * @author icatw
 * @since 2022-05-11 16:54:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Menu")
public class Menu implements Serializable {
    private static final long serialVersionUID = -13856332834239444L;
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
    private Boolean keepalive;

    /**
     * 是否要求权限
     */
    @TableField(value = "requireAuth")
    @ApiModelProperty("是否要求权限")
    private Boolean requireauth;

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
    private Boolean enabled;

    /**
     * 子菜单
     */
    @TableField(exist = false)
    @ApiModelProperty("子菜单")
    private List<Menu> children;

    /**
     * 角色列表
     */
    @TableField(exist = false)
    @ApiModelProperty("角色列表")
    private List<Role> roles;
}

