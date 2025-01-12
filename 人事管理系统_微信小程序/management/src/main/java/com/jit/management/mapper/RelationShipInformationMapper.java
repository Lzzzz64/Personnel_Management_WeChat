package com.jit.management.mapper;

import com.github.pagehelper.Page;
import com.jit.management.pojo.CareerAndForeignAndRelationPageQueryDTO;
import com.jit.management.pojo.CareerInformation;
import com.jit.management.pojo.RelationShipInformationVO;
import com.jit.management.pojo.RelationshipInformation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RelationShipInformationMapper {
    /*
    分页查询关系表
     */
    Page<RelationShipInformationVO> pageQuery(CareerAndForeignAndRelationPageQueryDTO careerAndForeignAndRelationPageQueryDTO);
    @Select("select * from relationship_information where employee_id = #{employeeId}")
    List<RelationshipInformation> getById(int employeeId);
    /**
     *
     * @param employeeId
     */
    @Delete("delete from relationship_information where employee_id = #{employeeId}")
    void deleteById(int employeeId);

    @Insert("insert into relationship_information " +
            "(employee_id, relationship, name, organization, phone) " +
            "values (#{employeeId},#{relationship},#{name},#{organization},#{phone})")
    int insert(RelationshipInformation relationshipInformation);
}
