package cn.icatw.yeb.server.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * (PoliticsStatus)实体类
 *
 * @author icatw
 * @since 2022-05-11 16:54:54
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false,of = "name")
@ApiModel("PoliticsStatus")
public class PoliticsStatus implements Serializable {
    private static final long serialVersionUID = -62615993444179234L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 政治面貌
     */
    @TableField(value = "name")
    @ApiModelProperty("政治面貌")
    @NonNull
    @Excel(name = "政治面貌", width = 15)
    private String name;
}

