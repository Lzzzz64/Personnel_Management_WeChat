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
public class TrialPeriodTime {
    private int employeeId; //员工号
    private LocalDateTime startTime; //试用期开始日期
    private LocalDateTime endTime; //试用期结束日期
}
