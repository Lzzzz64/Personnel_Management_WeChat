package com.jit.management.mapper;

import com.jit.management.pojo.EmployeeVO;
import com.jit.management.pojo.TrialPeriodTime;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface TrialPeriodTimeMapper {
    /*
    修改试用期
     */
    @Update("update trial_period_time set start_time=#{startTime},end_time=#{endTime} where employee_id=#{employeeId}")
    void update(TrialPeriodTime trialPeriodTime);

    /*
   添加员工入职过程中试用期表
    */
    @Insert("insert into trial_period_time(employee_id, start_time, end_time) values (#{employeeId},#{startTime},#{endTime})")
    void AddTrialPeriodTime(EmployeeVO employeeVO);
}
