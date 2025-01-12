package com.jit.management.service;

import com.jit.management.mapper.TrialPeriodTimeMapper;
import com.jit.management.pojo.EmployeeVO;
import com.jit.management.pojo.TrialPeriodTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class TrialPeriodTimeServicelmpl implements TrialPeriodTimeService{
    @Resource
    private TrialPeriodTimeMapper trialPeriodTimeMapper;
        /*
       修改试用期
        */
    @Override
    public void update(TrialPeriodTime trialPeriodTime) {
        trialPeriodTimeMapper.update(trialPeriodTime);
    }
    /*
        添加员工入职过程中试用期表
         */
    public void insertTrialPeriodTime(EmployeeVO employeeVO){
        trialPeriodTimeMapper.AddTrialPeriodTime(employeeVO);
    }
}
