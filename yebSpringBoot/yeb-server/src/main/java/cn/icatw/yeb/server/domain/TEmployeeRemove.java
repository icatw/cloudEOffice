package cn.icatw.yeb.server.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.*;

import java.io.Serializable;
import java.util.Date;

/**
 * (TEmployeeRemove)实体类
 *
 * @author icatw
 * @since 2022-05-10 16:54:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("$tableInfo.comment")
public class TEmployeeRemove implements Serializable {
    private static final long serialVersionUID = -20632306904104890L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 员工id
     */
    @TableField(value = "eid")
    @ApiModelProperty("员工id")
    private Integer eid;

    /**
     * 调动后部门
     */
    @TableField(value = "afterDepId")
    @ApiModelProperty("调动后部门")
    private Integer afterdepid;

    /**
     * 调动后职位
     */
    @TableField(value = "afterJobId")
    @ApiModelProperty("调动后职位")
    private Integer afterjobid;

    /**
     * 调动日期
     */
    @TableField(value = "removeDate")
    @ApiModelProperty("调动日期")
    private Date removedate;

    /**
     * 调动原因
     */
    @TableField(value = "reason")
    @ApiModelProperty("调动原因")
    private String reason;

    /**
     * 备注
     */
    @TableField(value = "remark")
    @ApiModelProperty("备注")
    private String remark;
}

