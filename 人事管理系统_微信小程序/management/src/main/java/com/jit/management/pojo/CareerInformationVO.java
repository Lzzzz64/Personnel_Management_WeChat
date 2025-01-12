package com.jit.management.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CareerInformationVO {
    private int employeeId; //员工号
    private String employeeName; //员工名
    List<CareerInformation> career;

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

    public List<CareerInformation> getCareer() {
        return career;
    }

    public void setCareer(List<CareerInformation> career) {
        this.career = career;
    }
}
