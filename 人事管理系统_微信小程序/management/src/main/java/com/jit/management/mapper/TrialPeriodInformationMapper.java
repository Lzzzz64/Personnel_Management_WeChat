package com.jit.management.mapper;

import com.github.pagehelper.Page;
import com.jit.management.pojo.EmployeeVO;
import com.jit.management.pojo.TrialPeriodPageQueryDTO;
import com.jit.management.pojo.TrialPeriodVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TrialPeriodInformationMapper {
    /*
    分页查询试用期员工
     */
    Page<TrialPeriodVO> pageQuery(TrialPeriodPageQueryDTO trialPeriodPageQueryDTO);
    /*
    分页查询已转正员工
     */
    Page<TrialPeriodVO> pageQuery1(TrialPeriodPageQueryDTO trialPeriodPageQueryDTO);
    /*
    更新result信息
     */
    @Update("update trial_period_information set result=#{result} where employee_id=#{employeeId}")
    void updateResult(TrialPeriodVO trialPeriodVO);
    /*
    更新试用员工信息
     */
    @Update("update trial_period_information a,trial_period_time b set b.start_time=#{startTime},b.end_time=#{endTime},a.comment=#{comment},a.result=#{result},a.process_date=#{processDate},a.note=#{note} where a.employee_id=#{employeeId} and b.employee_id=#{employeeId}")
    void updateTrialInformation(TrialPeriodVO trialPeriodVO);
    /*
    员工入职时添加试用表信息:添加employeeId 和result=0
     */
    @Insert("insert into trial_period_information(employee_id, comment, result, note)values (#{employeeId},'',0,'')")
    void insertTrialInformation(int employeeId);
    /*
    直接添加员工入职时添加试用表信息:添加employeeId 和result=0
     */
    @Insert("insert into trial_period_information(employee_id, comment, result, note)values (#{employeeId},'',0,'')")
    void insertTrialInformation1(EmployeeVO employeeVO);
}
