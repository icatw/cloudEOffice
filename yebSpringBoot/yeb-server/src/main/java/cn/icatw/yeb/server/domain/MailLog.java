package cn.icatw.yeb.server.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.*;

import java.io.Serializable;
import java.util.Date;

/**
 * (MailLog)实体类
 *
 * @author icatw
 * @since 2022-05-11 16:54:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("MailLog")
public class MailLog implements Serializable {
    private static final long serialVersionUID = -10788694793310180L;

    /**
     * 消息id
     */
    @TableField(value = "msgId")
    @ApiModelProperty("消息id")
    private String msgid;

    /**
     * 接收员工id
     */
    @TableField(value = "eid")
    @ApiModelProperty("接收员工id")
    private Integer eid;

    /**
     * 状态（0:消息投递中 1:投递成功 2:投递失败）
     */
    @TableField(value = "status")
    @ApiModelProperty("状态（0:消息投递中 1:投递成功 2:投递失败）")
    private Integer status;

    /**
     * 路由键
     */
    @TableField(value = "routeKey")
    @ApiModelProperty("路由键")
    private String routekey;

    /**
     * 交换机
     */
    @TableField(value = "exchange")
    @ApiModelProperty("交换机")
    private String exchange;

    /**
     * 重试次数
     */
    @TableField(value = "count")
    @ApiModelProperty("重试次数")
    private Integer count;

    /**
     * 重试时间
     */
    @TableField(value = "tryTime")
    @ApiModelProperty("重试时间")
    private Date trytime;

    /**
     * 创建时间
     */
    @TableField(value = "createTime")
    @ApiModelProperty("创建时间")
    private Date createtime;

    /**
     * 更新时间
     */
    @TableField(value = "updateTime")
    @ApiModelProperty("更新时间")
    private Date updatetime;
}

