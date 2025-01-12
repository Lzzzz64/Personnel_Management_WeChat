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
public class PositionTransferInformation {
    private int employeeId; //员工号
    private int transferPositionId; //调转后的岗位
    private String transferType; //调转类型,升职、降职、数据录入错误
    private String transferReason; //调转原因
    private LocalDateTime transferDate; //调动日期
    private String note; //备注
}
