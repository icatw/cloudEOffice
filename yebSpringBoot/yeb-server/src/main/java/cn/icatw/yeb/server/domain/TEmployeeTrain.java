package cn.icatw.yeb.server.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.*;

import java.io.Serializable;
import java.util.Date;

/**
 * (TEmployeeTrain)实体类
 *
 * @author icatw
 * @since 2022-05-10 16:54:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("$tableInfo.comment")
public class TEmployeeTrain implements Serializable {
    private static final long serialVersionUID = -26520356534066274L;
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

