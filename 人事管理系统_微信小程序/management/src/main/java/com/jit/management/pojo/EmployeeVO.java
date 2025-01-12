package com.jit.management.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeVO {
    private int employeeId; //员工号
    private String employeeName; //员工姓名
    private int gender; //性别 1：男, 2：女
    private LocalDateTime birth; //出生日期
    private String identityCard; //身份证号
    private int departmentId; //部门号
    private int positionId; //岗位号
    private LocalDateTime enrollDate; //入职日期
    private LocalDateTime workDate; //参加工作日期
    private int employeeForm; //用工形式 1：正式员工, 2：临时员工
    private int personnelSource; //人员来源 1：校园招聘,2：社会招聘,3：其它
    private int politicalOutlook; //政治面貌 1：党员,2：预备党员,3：团员,4：其他
    private String nation; //民族
    private String origin; //籍贯
    private String phone; //联系电话
    private String email; //电子邮件
    private double height; //身高
    private int bloodType; //血型 1：A 型,2：B 型,3：AB 型,4：0 型,5：其他血型
    private int maritalStatus; //婚姻状况 1：未婚,2：已婚,3：丧偶,4：离婚,5：其他
    private String birthPlace; //出生地
    private String householdRegistrationLocation; //户口所在地
    private int qualification; //最高学历 1：高中及以下,2：大专,3：本科,4：研究生
    private int degree; //最高学位 1：无学位,2：学士,3：双学士,4：硕士,5：博士,6：博士后
    private String graduateSchool; //毕业院校
    private String major; //所学专业
    private LocalDateTime graduateDate; //毕业日期
    private LocalDateTime startTime; //试用期开始日期
    private LocalDateTime endTime; //试用期结束日期
}
