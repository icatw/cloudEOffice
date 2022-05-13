package cn.icatw.yeb.server.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * (Department)实体类
 *
 * @author icatw
 * @since 2022-05-11 16:54:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Department")
public class Department implements Serializable {
    private static final long serialVersionUID = 741943075383409188L;
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
    @Excel(name = "部门",width = 15)
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
    private Boolean enabled;

    /**
     * 是否上级
     */
    @TableField(value = "isParent")
    @ApiModelProperty("是否上级")
    private Boolean parent;

    @ApiModelProperty("子部门列表")
    @TableField(exist = false)
    private List<Department> children;

    @ApiModelProperty("返回结果，存储过程使用")
    @TableField(exist = false)
    private Integer result;
}

