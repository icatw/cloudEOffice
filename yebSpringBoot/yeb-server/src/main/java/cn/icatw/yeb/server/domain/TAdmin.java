package cn.icatw.yeb.server.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.*;

import java.io.Serializable;
import java.util.Date;

/**
 * (TAdmin)实体类
 *
 * @author icatw
 * @since 2022-05-10 16:54:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("$tableInfo.comment")
public class TAdmin implements Serializable {
    private static final long serialVersionUID = 852151776851562037L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    @TableField(value = "name")
    @ApiModelProperty("姓名")
    private String name;

    /**
     * 手机号码
     */
    @TableField(value = "phone")
    @ApiModelProperty("手机号码")
    private String phone;

    /**
     * 住宅电话
     */
    @TableField(value = "telephone")
    @ApiModelProperty("住宅电话")
    private String telephone;

    /**
     * 联系地址
     */
    @TableField(value = "address")
    @ApiModelProperty("联系地址")
    private String address;

    /**
     * 是否启用
     */
    @TableField(value = "enabled")
    @ApiModelProperty("是否启用")
    private Integer enabled;

    /**
     * 用户名
     */
    @TableField(value = "username")
    @ApiModelProperty("用户名")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "password")
    @ApiModelProperty("密码")
    private String password;

    /**
     * 用户头像
     */
    @TableField(value = "userFace")
    @ApiModelProperty("用户头像")
    private String userface;

    /**
     * 备注
     */
    @TableField(value = "remark")
    @ApiModelProperty("备注")
    private String remark;
}

