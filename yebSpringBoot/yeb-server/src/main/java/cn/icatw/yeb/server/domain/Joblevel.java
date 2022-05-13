package cn.icatw.yeb.server.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * (Joblevel)实体类
 *
 * @author icatw
 * @since 2022-05-11 16:54:54
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false,of = "name")
@ApiModel("Joblevel")
public class Joblevel implements Serializable {
    private static final long serialVersionUID = -21092580804876926L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 职称名称
     */
    @TableField(value = "name")
    @ApiModelProperty("职称名称")
    @NonNull
    @Excel(name = "职称", width = 15)
    private String name;

    /**
     * 职称等级
     */
    @TableField(value = "titleLevel")
    @ApiModelProperty("职称等级")
    private String titlelevel;

    /**
     * 创建时间
     */
    @TableField(value = "createDate")
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private Date createdate;

    /**
     * 是否启用
     */
    @TableField(value = "enabled")
    @ApiModelProperty("是否启用")
    private Boolean enabled;
}

