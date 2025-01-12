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
public class DepartmentTransferInformation {
    private int employeeId; //员工号
    private int transferDepartmentId; //调转后的部门号
    private String transferType; //调转类型,主动调动，被动调动
    private String transferReason; //调转原因
    private String note; //备注
    private LocalDateTime transferDate; //调动日期
}
