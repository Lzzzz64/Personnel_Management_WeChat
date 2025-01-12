package com.jit.management.service;

import com.jit.management.pojo.*;
import com.jit.management.result.PageResult;

import java.util.List;

public interface EmployeeService {
    /*
    新增员工入职
     */
    void insertEmployee(EmployeeVO employeeVO);



    /*
    查询员工入职信息
    根据employeeId
     */
    Employee information(int employeeId);

    /*
    分页查询
    查询员工未入职信息
     */
    PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /*
    分页查询
    查询员工已入职信息
     */
    PageResult pageQuery1(EmployeePageQueryDTO employeePageQueryDTO);

    /*
    修改员工信息
     */
    void update(EmployeeVO employeeVO);

    /*
    将员工入职
     */
    void updateStatus(int employeeId);

    /*
    将部门调动后的部门号传到employee表中修改
     */
    void updateDeparementId(DepartmentTransferInformation departmentTransferInformation);

    /*
    将岗位调动后的岗位号传到employee表中修改
     */
    void updatePositionId(PositionTransferInformation positionTransferInformation);
    /*
    离职:将status改为2
     */
    void updateStatusTo2(DimissionInformation dimissionInformation);


    /**
     * 根据入职时间获取员工数据
     * @param reportDTO
     * @return
     */
    List<EnrollEmployeeVO> getByEnrollDate(ReportDTO reportDTO);

    /**
     * 根据离职时间获取员工数据
     * @param reportDTO
     * @return
     */
    List<DimissionVO> getByDismissDate(ReportDTO reportDTO);

    /**
     * 根据部门调动时间获取员工数据
     * @param reportDTO
     * @return
     */
    List<DepartmentTransferVO> getByDepartmentTransferDate(ReportDTO reportDTO);

    /**
     * 根据岗位调动时间获取员工数据
     * @param reportDTO
     * @return
     */
    List<PositionTransferVO> getByPositionTransferDate(ReportDTO reportDTO);

}
