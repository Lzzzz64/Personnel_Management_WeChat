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
public class EnrollEmployeeVO {
    private int employeeId; //员工号
    private String employeeName; //员工姓名
    private int gender; //性别 1：男, 2：女
    private LocalDateTime birth; //出生日期
    private String identityCard; //身份证号
    private int departmentId; //部门号
    private String departmentName;
    private int positionId; //岗位号
    private String positionName;
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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public LocalDateTime getBirth() {
        return birth;
    }

    public void setBirth(LocalDateTime birth) {
        this.birth = birth;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public LocalDateTime getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(LocalDateTime enrollDate) {
        this.enrollDate = enrollDate;
    }

    public LocalDateTime getWorkDate() {
        return workDate;
    }

    public void setWorkDate(LocalDateTime workDate) {
        this.workDate = workDate;
    }

    public int getEmployeeForm() {
        return employeeForm;
    }

    public void setEmployeeForm(int employeeForm) {
        this.employeeForm = employeeForm;
    }

    public int getPersonnelSource() {
        return personnelSource;
    }

    public void setPersonnelSource(int personnelSource) {
        this.personnelSource = personnelSource;
    }

    public int getPoliticalOutlook() {
        return politicalOutlook;
    }

    public void setPoliticalOutlook(int politicalOutlook) {
        this.politicalOutlook = politicalOutlook;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getBloodType() {
        return bloodType;
    }

    public void setBloodType(int bloodType) {
        this.bloodType = bloodType;
    }

    public int getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(int maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getHouseholdRegistrationLocation() {
        return householdRegistrationLocation;
    }

    public void setHouseholdRegistrationLocation(String householdRegistrationLocation) {
        this.householdRegistrationLocation = householdRegistrationLocation;
    }

    public int getQualification() {
        return qualification;
    }

    public void setQualification(int qualification) {
        this.qualification = qualification;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public LocalDateTime getGraduateDate() {
        return graduateDate;
    }

    public void setGraduateDate(LocalDateTime graduateDate) {
        this.graduateDate = graduateDate;
    }
}
