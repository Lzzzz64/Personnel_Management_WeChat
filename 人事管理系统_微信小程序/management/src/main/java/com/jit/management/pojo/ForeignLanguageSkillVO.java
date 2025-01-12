package com.jit.management.pojo;

import lombok.Data;

import java.util.List;

@Data
public class ForeignLanguageSkillVO {
    private int employeeId;
    private String employeeName;
    private List<ForeignLanguageSkill> foreign;

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

    public List<ForeignLanguageSkill> getForeign() {
        return foreign;
    }

    public void setForeign(List<ForeignLanguageSkill> foreign) {
        this.foreign = foreign;
    }
}
