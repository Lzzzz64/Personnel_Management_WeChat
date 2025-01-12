package com.jit.management.service;

import com.jit.management.pojo.EmployeeVO;
import com.jit.management.pojo.TrialPeriodTime;

public interface TrialPeriodTimeService {
    /*
    修改试用期
     */
    void update(TrialPeriodTime trialPeriodTime);/*

    添加员工入职过程中试用期表
     */
    void insertTrialPeriodTime(EmployeeVO employeeVO);
}
