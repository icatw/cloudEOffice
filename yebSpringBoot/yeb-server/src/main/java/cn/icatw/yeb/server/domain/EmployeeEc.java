package cn.icatw.yeb.server.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.*;

import java.io.Serializable;
import java.util.Date;

/**
 * (EmployeeEc)实体类
 *
 * @author icatw
 * @since 2022-05-11 16:54:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("EmployeeEc")
public class EmployeeEc implements Serializable {
    private static final long serialVersionUID = -81934409981413659L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 员工编号
     */
    @TableField(value = "eid")
    @ApiModelProperty("员工编号")
    private Integer eid;

    /**
     * 奖罚日期
     */
    @TableField(value = "ecDate")
    @ApiModelProperty("奖罚日期")
    private Date ecdate;

    /**
     * 奖罚原因
     */
    @TableField(value = "ecReason")
    @ApiModelProperty("奖罚原因")
    private String ecreason;

    /**
     * 奖罚分
     */
    @TableField(value = "ecPoint")
    @ApiModelProperty("奖罚分")
    private Integer ecpoint;

    /**
     * 奖罚类别，0：奖，1：罚
     */
    @TableField(value = "ecType")
    @ApiModelProperty("奖罚类别，0：奖，1：罚")
    private Integer ectype;

    /**
     * 备注
     */
    @TableField(value = "remark")
    @ApiModelProperty("备注")
    private String remark;
}

