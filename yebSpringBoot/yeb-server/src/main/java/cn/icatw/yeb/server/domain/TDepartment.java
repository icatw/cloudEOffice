package cn.icatw.yeb.server.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.*;

import java.io.Serializable;
import java.util.Date;

/**
 * (TDepartment)实体类
 *
 * @author icatw
 * @since 2022-05-10 16:54:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("$tableInfo.comment")
public class TDepartment implements Serializable {
    private static final long serialVersionUID = -91948317133681422L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 部门名称
     */
    @TableField(value = "name")
    @ApiModelProperty("部门名称")
    private String name;

    /**
     * 父id
     */
    @TableField(value = "parentId")
    @ApiModelProperty("父id")
    private Integer parentid;

    /**
     * 路径
     */
    @TableField(value = "depPath")
    @ApiModelProperty("路径")
    private String deppath;

    /**
     * 是否启用
     */
    @TableField(value = "enabled")
    @ApiModelProperty("是否启用")
    private Integer enabled;

    /**
     * 是否上级
     */
    @TableField(value = "isParent")
    @ApiModelProperty("是否上级")
    private Integer isparent;
}

