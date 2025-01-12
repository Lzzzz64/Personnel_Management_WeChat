package com.jit.management.service;

import com.github.pagehelper.Page;
import com.jit.management.pojo.EmployeeVO;
import com.jit.management.pojo.TrialPeriodPageQueryDTO;
import com.jit.management.pojo.TrialPeriodVO;
import com.jit.management.result.PageResult;

public interface TrialPeriodInformationService {
    /*
    分页查询试用期员工
     */
    PageResult pageQuery(TrialPeriodPageQueryDTO trialPeriodPageQueryDTO);
    /*
    分页查询已转正员工
     */
    PageResult pageQuery1(TrialPeriodPageQueryDTO trialPeriodPageQueryDTO);
    /*
    更新result信息
     */
    void updateResult(TrialPeriodVO trialPeriodVO);
    /*
    更新试用员工信息
     */
    void updateTrialInformation(TrialPeriodVO trialPeriodVO);
    /*
    员工入职时添加试用表信息:添加employeeId 和result=0
     */
    void insertTrialInformation(int employeeId);
    /*
    直接添加员工入职时添加试用表信息:添加employeeId 和result=0
     */
    void insertTrialInformation1(EmployeeVO employeeVO);
}
