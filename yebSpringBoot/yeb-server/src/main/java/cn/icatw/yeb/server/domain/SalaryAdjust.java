package cn.icatw.yeb.server.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.*;

import java.io.Serializable;
import java.util.Date;

/**
 * (SalaryAdjust)实体类
 *
 * @author icatw
 * @since 2022-05-11 16:54:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("SalaryAdjust")
public class SalaryAdjust implements Serializable {
    private static final long serialVersionUID = 250929570891990458L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 员工ID
     */
    @TableField(value = "eid")
    @ApiModelProperty("员工ID")
    private Integer eid;

    /**
     * 调薪日期
     */
    @TableField(value = "asDate")
    @ApiModelProperty("调薪日期")
    private Date asdate;

    /**
     * 调前薪资
     */
    @TableField(value = "beforeSalary")
    @ApiModelProperty("调前薪资")
    private Integer beforesalary;

    /**
     * 调后薪资
     */
    @TableField(value = "afterSalary")
    @ApiModelProperty("调后薪资")
    private Integer aftersalary;

    /**
     * 调薪原因
     */
    @TableField(value = "reason")
    @ApiModelProperty("调薪原因")
    private String reason;

    /**
     * 备注
     */
    @TableField(value = "remark")
    @ApiModelProperty("备注")
    private String remark;
}

