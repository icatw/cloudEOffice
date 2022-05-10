package cn.icatw.yeb.server.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.*;

import java.io.Serializable;
import java.util.Date;

/**
 * (TAppraise)实体类
 *
 * @author icatw
 * @since 2022-05-10 16:54:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("$tableInfo.comment")
public class TAppraise implements Serializable {
    private static final long serialVersionUID = 332759691164551210L;
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
     * 考评日期
     */
    @TableField(value = "appDate")
    @ApiModelProperty("考评日期")
    private Date appdate;

    /**
     * 考评结果
     */
    @TableField(value = "appResult")
    @ApiModelProperty("考评结果")
    private String appresult;

    /**
     * 考评内容
     */
    @TableField(value = "appContent")
    @ApiModelProperty("考评内容")
    private String appcontent;

    /**
     * 备注
     */
    @TableField(value = "remark")
    @ApiModelProperty("备注")
    private String remark;
}

