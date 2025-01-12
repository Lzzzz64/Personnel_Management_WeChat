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
public class TrialPeriodInformation {
    private int employeeId; //员工号
    private String comment; //试用期部门考核评语
    private int result; //考核结果
    private LocalDateTime processDate; //处理日期
    private String note; //备注
}
