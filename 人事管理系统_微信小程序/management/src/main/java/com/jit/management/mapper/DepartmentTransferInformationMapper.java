package com.jit.management.mapper;

import com.jit.management.pojo.DepartmentTransferInformation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DepartmentTransferInformationMapper {
    /*
    新增部门调动表
     */
    @Insert("insert into department_transfer_information(employee_id, transfer_department_id, transfer_type, transfer_reason, transfer_date, note)values (#{employeeId},#{transferDepartmentId},#{transferType},#{transferReason},#{transferDate},#{note})")
    void addToDepartment(DepartmentTransferInformation departmentTransferInformation);
}
