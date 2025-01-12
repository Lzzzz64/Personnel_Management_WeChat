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
public class DimissionVO {
    private int employeeId;
    private String employeeName;
    private LocalDateTime dimissionDate;
    private String dimissionType;
    private String dimissionGo;
    private String note;

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

    public LocalDateTime getDimissionDate() {
        return dimissionDate;
    }

    public void setDimissionDate(LocalDateTime dimissionDate) {
        this.dimissionDate = dimissionDate;
    }

    public String getDimissionType() {
        return dimissionType;
    }

    public void setDimissionType(String dimissionType) {
        this.dimissionType = dimissionType;
    }

    public String getDimissionGo() {
        return dimissionGo;
    }

    public void setDimissionGo(String dimissionGo) {
        this.dimissionGo = dimissionGo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

