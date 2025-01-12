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
public class DimissionInformation {
    private int employeeId; //员工号
    private LocalDateTime dimissionDate; //离职日期
    private String dimissionType; //离职类型 主动辞职、辞退、退休、开除、试用期未通过。
    private String dimissionGo; //离职去向
    private String note; //备注
}
