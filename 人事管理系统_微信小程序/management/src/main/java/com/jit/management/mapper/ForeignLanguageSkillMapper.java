package com.jit.management.mapper;

import com.github.pagehelper.Page;
import com.jit.management.pojo.CareerAndForeignAndRelationPageQueryDTO;
import com.jit.management.pojo.ForeignLanguageSkill;
import com.jit.management.pojo.ForeignLanguageSkillVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ForeignLanguageSkillMapper {
    /*
    分页查询外语能力
     */
    Page<ForeignLanguageSkillVO> pageQuery(CareerAndForeignAndRelationPageQueryDTO careerAndForeignAndRelationPageQueryDTO);

    @Select("select * from foreign_language_skill where employee_id = #{employeeId}")
    List<ForeignLanguageSkill> getById(int employeeId);

    /**
     * 根据员工id删除所有的外语能力信息
     * @param employeeId
     */
    @Delete("delete from foreign_language_skill where employee_id = #{employeeId}")
    void deleteById(int employeeId);

    /**
     * 插入外语能力信息
     * @param foreignLanguageSkill
     */
    @Insert("insert into foreign_language_skill " +
            "(employee_id, type, proficiency) " +
            "VALUES (#{employeeId},#{type},#{proficiency})")
    int insert(ForeignLanguageSkill foreignLanguageSkill);
}
