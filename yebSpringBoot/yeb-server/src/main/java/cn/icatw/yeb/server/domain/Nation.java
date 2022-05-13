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
 * (Nation)实体类
 *
 * @author icatw
 * @since 2022-05-11 16:54:54
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, of = "name")
@ApiModel("Nation")
public class Nation implements Serializable {
    private static final long serialVersionUID = 175011702776125447L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 民族
     */
    @TableField(value = "name")
    @ApiModelProperty("民族")
    @NonNull
    @Excel(name = "民族")
    private String name;
}

