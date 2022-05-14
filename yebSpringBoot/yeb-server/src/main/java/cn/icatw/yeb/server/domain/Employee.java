package cn.icatw.yeb.server.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
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
import java.time.LocalDate;

/**
 * (Employee)实体类
 *
 * @author icatw
 * @since 2022-05-11 16:54:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Employee")
public class Employee implements Serializable {
    private static final long serialVersionUID = -76220695296648099L;
    /**
     * 员工编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    //@Excel(name = "员工编号")
    private Integer id;

    /**
     * 员工姓名
     */
    @TableField(value = "name")
    @ApiModelProperty("员工姓名")
    @Excel(name = "员工姓名")
    private String name;

    /**
     * 性别
     */
    @TableField(value = "gender")
    @ApiModelProperty("性别")
    @Excel(name = "性别")
    private String gender;

    /**
     * 出生日期
     */
    @TableField(value = "birthday")
    @ApiModelProperty("出生日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    @Excel(name = "出生日期", width = 20, format = "yyyy-MM-dd")
    private LocalDate birthday;

    /**
     * 身份证号
     */
    @TableField(value = "idCard")
    @ApiModelProperty("身份证号")
    @Excel(name = "身份证号", width = 30)
    private String idcard;

    /**
     * 婚姻状况
     */
    @TableField(value = "wedlock")
    @ApiModelProperty("婚姻状况")
    @Excel(name = "婚姻状况")
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
    @Excel(name = "籍贯")
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
    @Excel(name = "邮箱", width = 30)
    private String email;

    /**
     * 电话号码
     */
    @TableField(value = "phone")
    @ApiModelProperty("电话号码")
    @Excel(name = "电话号码", width = 15)
    private String phone;

    /**
     * 联系地址
     */
    @TableField(value = "address")
    @ApiModelProperty("联系地址")
    @Excel(name = "联系地址", width = 40)
    private String address;

    /**
     * 所属部门
     */
    @TableField(value = "departmentId")
    @ApiModelProperty("所属部门")
    @Excel(name = "所属部门")
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
    @Excel(name = "聘用形式")
    private String engageform;

    /**
     * 最高学历
     */
    @TableField(value = "tiptopDegree")
    @ApiModelProperty("最高学历")
    @Excel(name = "最高学历")
    private Object tiptopdegree;

    /**
     * 所属专业
     */
    @TableField(value = "specialty")
    @ApiModelProperty("所属专业")
    @Excel(name = "所属专业", width = 20)
    private String specialty;

    /**
     * 毕业院校
     */
    @TableField(value = "school")
    @ApiModelProperty("毕业院校")
    @Excel(name = "毕业院校", width = 20)
    private String school;

    /**
     * 入职日期
     */
    @TableField(value = "beginDate")
    @ApiModelProperty("入职日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    @Excel(name = "入职日期", width = 20, format = "yyyy-MM-dd")
    private LocalDate begindate;

    /**
     * 在职状态
     */
    @TableField(value = "workState")
    @ApiModelProperty("在职状态")
    @Excel(name = "在职状态")
    private String workstate;

    /**
     * 工号
     */
    @TableField(value = "workID")
    @ApiModelProperty("工号")
    @Excel(name = "工号")
    private String workid;

    /**
     * 合同期限
     */
    @TableField(value = "contractTerm")
    @ApiModelProperty("合同期限")
    @Excel(name = "合同期限", suffix = "年")
    private Object contractterm;

    /**
     * 转正日期
     */
    @TableField(value = "conversionTime")
    @ApiModelProperty("转正日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    @Excel(name = "转正日期", width = 20, format = "yyyy-MM-dd")
    private LocalDate conversiontime;

    /**
     * 离职日期
     */
    @TableField(value = "notWorkDate")
    @ApiModelProperty("离职日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    @Excel(name = "离职日期", width = 20, format = "yyyy-MM-dd")
    private LocalDate notworkdate;

    /**
     * 合同起始日期
     */
    @TableField(value = "beginContract")
    @ApiModelProperty("合同起始日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    @Excel(name = "合同起始日期", width = 20, format = "yyyy-MM-dd")
    private LocalDate begincontract;

    /**
     * 合同终止日期
     */
    @TableField(value = "endContract")
    @ApiModelProperty("合同终止日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    @Excel(name = "合同终止日期", width = 20, format = "yyyy-MM-dd")
    private LocalDate endcontract;

    /**
     * 工龄
     */
    @TableField(value = "workAge")
    @ApiModelProperty("工龄")
    @Excel(name = "工龄")
    private Integer workage;

    /**
     * 工资账套ID
     */
    @TableField(value = "salaryId")
    @ApiModelProperty("工资账套ID")
    private Integer salaryid;

    @ApiModelProperty(value = "民族")
    @TableField(exist = false)
    @ExcelEntity(name = "民族")
    private Nation nation;

    @ApiModelProperty(value = "政治面貌")
    @TableField(exist = false)
    @ExcelEntity(name = "政治面貌")
    private PoliticsStatus politicsStatus;

    @ApiModelProperty(value = "部门")
    @TableField(exist = false)
    @ExcelEntity(name = "部门")
    private Department department;

    @ApiModelProperty(value = "职称")
    @TableField(exist = false)
    @ExcelEntity(name = "职称")
    private Joblevel joblevel;

    @ApiModelProperty(value = "职位")
    @TableField(exist = false)
    @ExcelEntity(name = "职位")
    private Position position;

    @ApiModelProperty(value = "工资账套")
    @TableField(exist = false)
    private Salary salary;
}

