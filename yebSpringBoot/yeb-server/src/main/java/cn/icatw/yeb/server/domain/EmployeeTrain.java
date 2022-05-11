package cn.icatw.yeb.server.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.*;

import java.io.Serializable;
import java.util.Date;

/**
 * (EmployeeTrain)实体类
 *
 * @author icatw
 * @since 2022-05-11 16:54:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("EmployeeTrain")
public class EmployeeTrain implements Serializable {
    private static final long serialVersionUID = 290765153192750581L;
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
     * 培训日期
     */
    @TableField(value = "trainDate")
    @ApiModelProperty("培训日期")
    private Date traindate;

    /**
     * 培训内容
     */
    @TableField(value = "trainContent")
    @ApiModelProperty("培训内容")
    private String traincontent;

    /**
     * 备注
     */
    @TableField(value = "remark")
    @ApiModelProperty("备注")
    private String remark;
}

