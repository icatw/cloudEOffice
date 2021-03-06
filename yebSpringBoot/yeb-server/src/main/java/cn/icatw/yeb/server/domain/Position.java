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
import java.time.LocalDateTime;

/**
 * (Position)实体类
 *
 * @author icatw
 * @since 2022-05-11 16:54:54
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, of = "name")
@ApiModel("Position")
public class Position implements Serializable {
    private static final long serialVersionUID = -15118307803104487L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 职位
     */
    @TableField(value = "name")
    @ApiModelProperty("职位")
    @NonNull
    @Excel(name = "职位", width = 15)
    private String name;

    /**
     * 创建时间
     */
    @TableField(value = "createDate")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    @ApiModelProperty("创建时间")
    private LocalDateTime createdate;

    /**
     * 是否启用
     */
    @TableField(value = "enabled")
    @ApiModelProperty("是否启用")
    private Boolean enabled;
}

