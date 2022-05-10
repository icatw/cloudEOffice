package cn.icatw.yeb.server.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.*;

import java.io.Serializable;
import java.util.Date;

/**
 * (TOplog)实体类
 *
 * @author icatw
 * @since 2022-05-10 16:54:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("$tableInfo.comment")
public class TOplog implements Serializable {
    private static final long serialVersionUID = -11318408238843756L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 添加日期
     */
    @TableField(value = "addDate")
    @ApiModelProperty("添加日期")
    private Date adddate;

    /**
     * 操作内容
     */
    @TableField(value = "operate")
    @ApiModelProperty("操作内容")
    private String operate;

    /**
     * 操作员ID
     */
    @TableField(value = "adminid")
    @ApiModelProperty("操作员ID")
    private Integer adminid;
}

