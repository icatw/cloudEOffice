package cn.icatw.yeb.server.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * (Salary)实体类
 *
 * @author icatw
 * @since 2022-05-11 16:54:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Salary")
public class Salary implements Serializable {
    private static final long serialVersionUID = 700527427324150127L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 基本工资
     */
    @TableField(value = "basicSalary")
    @ApiModelProperty("基本工资")
    private Integer basicsalary;

    /**
     * 奖金
     */
    @TableField(value = "bonus")
    @ApiModelProperty("奖金")
    private Integer bonus;

    /**
     * 午餐补助
     */
    @TableField(value = "lunchSalary")
    @ApiModelProperty("午餐补助")
    private Integer lunchsalary;

    /**
     * 交通补助
     */
    @TableField(value = "trafficSalary")
    @ApiModelProperty("交通补助")
    private Integer trafficsalary;

    /**
     * 应发工资
     */
    @TableField(value = "allSalary")
    @ApiModelProperty("应发工资")
    private Integer allsalary;

    /**
     * 养老金基数
     */
    @TableField(value = "pensionBase")
    @ApiModelProperty("养老金基数")
    private Integer pensionbase;

    /**
     * 养老金比率
     */
    @TableField(value = "pensionPer")
    @ApiModelProperty("养老金比率")
    private Float pensionper;

    /**
     * 启用时间
     */
    @TableField(value = "createDate")
    @ApiModelProperty("启用时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private LocalDateTime createdate;

    /**
     * 医疗基数
     */
    @TableField(value = "medicalBase")
    @ApiModelProperty("医疗基数")
    private Integer medicalbase;

    /**
     * 医疗保险比率
     */
    @TableField(value = "medicalPer")
    @ApiModelProperty("医疗保险比率")
    private Float medicalper;

    /**
     * 公积金基数
     */
    @TableField(value = "accumulationFundBase")
    @ApiModelProperty("公积金基数")
    private Integer accumulationfundbase;

    /**
     * 公积金比率
     */
    @TableField(value = "accumulationFundPer")
    @ApiModelProperty("公积金比率")
    private Float accumulationfundper;

    /**
     * 名称
     */
    @TableField(value = "name")
    @ApiModelProperty("名称")
    private String name;
}

