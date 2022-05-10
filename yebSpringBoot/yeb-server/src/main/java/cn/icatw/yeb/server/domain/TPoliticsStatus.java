package cn.icatw.yeb.server.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.*;

import java.io.Serializable;
import java.util.Date;

/**
 * (TPoliticsStatus)实体类
 *
 * @author icatw
 * @since 2022-05-10 16:54:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("$tableInfo.comment")
public class TPoliticsStatus implements Serializable {
    private static final long serialVersionUID = -36917263105295870L;
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
    private String name;
}

