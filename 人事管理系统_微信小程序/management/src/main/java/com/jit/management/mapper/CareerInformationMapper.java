package com.jit.management.mapper;

import com.github.pagehelper.Page;
import com.jit.management.pojo.CareerAndForeignAndRelationPageQueryDTO;
import com.jit.management.pojo.CareerInformation;
import com.jit.management.pojo.CareerInformationVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CareerInformationMapper {
    /*
    分页查询职业生涯信息
     */
    Page<CareerInformationVO> pageQuery(CareerAndForeignAndRelationPageQueryDTO careerInformationDTO);

    @Select("select * from career_information where employee_id = #{employeeId}")
    List<CareerInformation> getById(int employeeId);

    /**
     *根据员工id删除所有的职业生涯信息
     * @param employeeId
     */
    @Delete("delete from career_information where employee_id = #{employeeId}")
    void deleteById(int employeeId);

    @Insert("insert into career_information " +
            "(employee_id, start_time, end_time, organization_name, position, job_description, salary, note) " +
            "values (#{employeeId},#{startTime},#{endTime},#{organizationName},#{position},#{jobDescription},#{salary},#{note})")
    int insert(CareerInformation careerInformation);
}
