package cn.icatw.yeb.server.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.*;

import java.io.Serializable;
import java.util.Date;

/**
 * (SysMsg)实体类
 *
 * @author icatw
 * @since 2022-05-11 16:54:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("SysMsg")
public class SysMsg implements Serializable {
    private static final long serialVersionUID = -53308675647097960L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 消息id
     */
    @TableField(value = "mid")
    @ApiModelProperty("消息id")
    private Integer mid;

    /**
     * 0表示群发消息
     */
    @TableField(value = "type")
    @ApiModelProperty("0表示群发消息")
    private Integer type;

    /**
     * 这条消息是给谁的
     */
    @TableField(value = "adminid")
    @ApiModelProperty("这条消息是给谁的")
    private Integer adminid;

    /**
     * 0 未读 1 已读
     */
    @TableField(value = "state")
    @ApiModelProperty("0 未读 1 已读")
    private Integer state;
}

