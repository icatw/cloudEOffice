package cn.icatw.yeb.server.domain;

import cn.icatw.yeb.server.config.CustomAuthorityDeserializer;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (Admin)实体类
 *
 * @author icatw
 * @since 2022-05-11 16:54:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Admin")
@TableName("")
public class Admin implements Serializable, UserDetails {
    private static final long serialVersionUID = -20362868945856008L;
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
    @Getter(AccessLevel.NONE)
    private Boolean enabled;

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
    @JsonIgnore
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

    /**
     * 角色
     */
    @TableField(exist = false)
    @ApiModelProperty("角色")
    private List<Role> roles;

    @Override
    @JsonDeserialize(using = CustomAuthorityDeserializer.class)
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}

