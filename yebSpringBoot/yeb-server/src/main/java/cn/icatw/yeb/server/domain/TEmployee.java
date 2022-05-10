package cn.icatw.yeb.server.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.*;

import java.io.Serializable;
import java.util.Date;

/**
 * (TEmployee)实体类
 *
 * @author icatw
 * @since 2022-05-10 16:54:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("$tableInfo.comment")
public class TEmployee implements Serializable {
    private static final long serialVersionUID = -59032006197141539L;
    /**
     * 员工编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 员工姓名
     */
    @TableField(value = "name")
    @ApiModelProperty("员工姓名")
    private String name;

    /**
     * 性别
     */
    @TableField(value = "gender")
    @ApiModelProperty("性别")
    private String gender;

    /**
     * 出生日期
     */
    @TableField(value = "birthday")
    @ApiModelProperty("出生日期")
    private Date birthday;

    /**
     * 身份证号
     */
    @TableField(value = "idCard")
    @ApiModelProperty("身份证号")
    private String idcard;

    /**
     * 婚姻状况
     */
    @TableField(value = "wedlock")
    @ApiModelProperty("婚姻状况")
    private Object wedlock;

    /**
     * 民族
     */
    @TableField(value = "nationId")
    @ApiModelProperty("民族")
    private Integer nationid;

    /**
     * 籍贯
     */
    @TableField(value = "nativePlace")
    @ApiModelProperty("籍贯")
    private String nativeplace;

    /**
     * 政治面貌
     */
    @TableField(value = "politicId")
    @ApiModelProperty("政治面貌")
    private Integer politicid;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 电话号码
     */
    @TableField(value = "phone")
    @ApiModelProperty("电话号码")
    private String phone;

    /**
     * 联系地址
     */
    @TableField(value = "address")
    @ApiModelProperty("联系地址")
    private String address;

    /**
     * 所属部门
     */
    @TableField(value = "departmentId")
    @ApiModelProperty("所属部门")
    private Integer departmentid;

    /**
     * 职称ID
     */
    @TableField(value = "jobLevelId")
    @ApiModelProperty("职称ID")
    private Integer joblevelid;

    /**
     * 职位ID
     */
    @TableField(value = "posId")
    @ApiModelProperty("职位ID")
    private Integer posid;

    /**
     * 聘用形式
     */
    @TableField(value = "engageForm")
    @ApiModelProperty("聘用形式")
    private String engageform;

    /**
     * 最高学历
     */
    @TableField(value = "tiptopDegree")
    @ApiModelProperty("最高学历")
    private Object tiptopdegree;

    /**
     * 所属专业
     */
    @TableField(value = "specialty")
    @ApiModelProperty("所属专业")
    private String specialty;

    /**
     * 毕业院校
     */
    @TableField(value = "school")
    @ApiModelProperty("毕业院校")
    private String school;

    /**
     * 入职日期
     */
    @TableField(value = "beginDate")
    @ApiModelProperty("入职日期")
    private Date begindate;

    /**
     * 在职状态
     */
    @TableField(value = "workState")
    @ApiModelProperty("在职状态")
    private Object workstate;

    /**
     * 工号
     */
    @TableField(value = "workID")
    @ApiModelProperty("工号")
    private String workid;

    /**
     * 合同期限
     */
    @TableField(value = "contractTerm")
    @ApiModelProperty("合同期限")
    private Object contractterm;

    /**
     * 转正日期
     */
    @TableField(value = "conversionTime")
    @ApiModelProperty("转正日期")
    private Date conversiontime;

    /**
     * 离职日期
     */
    @TableField(value = "notWorkDate")
    @ApiModelProperty("离职日期")
    private Date notworkdate;

    /**
     * 合同起始日期
     */
    @TableField(value = "beginContract")
    @ApiModelProperty("合同起始日期")
    private Date begincontract;

    /**
     * 合同终止日期
     */
    @TableField(value = "endContract")
    @ApiModelProperty("合同终止日期")
    private Date endcontract;

    /**
     * 工龄
     */
    @TableField(value = "workAge")
    @ApiModelProperty("工龄")
    private Integer workage;

    /**
     * 工资账套ID
     */
    @TableField(value = "salaryId")
    @ApiModelProperty("工资账套ID")
    private Integer salaryid;
}

