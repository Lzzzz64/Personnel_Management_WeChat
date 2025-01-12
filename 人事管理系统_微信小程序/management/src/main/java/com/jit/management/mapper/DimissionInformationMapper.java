package com.jit.management.mapper;

import com.jit.management.pojo.DimissionInformation;
import org.apache.ibatis.annotations.Insert;

public interface DimissionInformationMapper {
    /*
    新增离职表数据
     */
    @Insert("insert into dimission_information(employee_id, dimission_date, dimission_type, dimission_go, note) VALUES (#{employeeId},#{dimissionDate},#{dimissionType},#{dimissionGo},#{note})")
    void insertDimissionInfo(DimissionInformation dimissionInformation);
}
