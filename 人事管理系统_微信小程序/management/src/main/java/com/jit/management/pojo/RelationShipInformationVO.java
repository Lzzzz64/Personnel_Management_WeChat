package com.jit.management.pojo;

import lombok.Data;

import java.util.List;

@Data
public class RelationShipInformationVO {
    private int employeeId; //员工号
    private String employeeName; //员工名
    List<RelationshipInformation> relation;

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

    public List<RelationshipInformation> getRelation() {
        return relation;
    }

    public void setRelation(List<RelationshipInformation> relation) {
        this.relation = relation;
    }
}
