package com.jit.management.mapper;

import com.github.pagehelper.Page;
import com.jit.management.pojo.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface EmployeeMapper {
    /**
     *添加员工入职
    */
    @Insert("insert into employee (employee_id, employee_name, gender, birth, identity_card, department_id, position_id, enroll_date, work_date, employee_form, personnel_source, political_outlook, nation, origin, phone, email, height, blood_type, marital_status, birth_place, household_registration_location, qualification, degree, graduate_school, major, graduate_date, status) values (#{employeeId}, #{employeeName}, #{gender}, #{birth}, #{identityCard}, #{departmentId}, #{positionId}, #{enrollDate}, #{workDate}, #{employeeForm}, #{personnelSource}, #{politicalOutlook}, #{nation}, #{origin}, #{phone}, #{email}, #{height}, #{bloodType}, #{maritalStatus}, #{birthPlace}, #{householdRegistrationLocation}, #{qualification}, #{degree}, #{graduateSchool}, #{major}, #{graduateDate},1)")
    void AddEmployee(EmployeeVO employeeVO);

    /**
     * 查看员工入职信息
      根据employeeId
     */
    @Select("select * from employee where employee_id=#{employeeId}")
    Employee FindEmployeeById(int employeeId);
    /*
    分页查询
    员工未入职信息
     */
    Page<EmployeeVO> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);
    /*
    分页查询
    员工已入职信息
     */
    Page<EmployeeVO> pageQuery1(EmployeePageQueryDTO employeePageQueryDTO);
    /*
    修改员工信息
     */
    @Update("update employee set employee_name=#{employeeName},gender=#{gender},birth=#{birth},identity_card=#{identityCard},department_id=#{departmentId},position_id=#{positionId},enroll_date=#{enrollDate},work_date=#{workDate},employee_form=#{employeeForm},personnel_source=#{personnelSource},political_outlook=#{politicalOutlook},nation=#{nation},origin=#{origin},phone=#{phone},email=#{email},height=#{height},blood_type=#{bloodType},marital_status=#{maritalStatus},birth_place=#{birthPlace},household_registration_location=#{householdRegistrationLocation},qualification=#{qualification},degree=#{degree},graduate_school=#{graduateSchool},major=#{major},graduate_date=#{graduateDate} where employee_id=#{employeeId}")
    void update(EmployeeVO employeeVO);
    /*
    将员工入职
     */
    @Update("update employee set status=1 where employee_id=#{employeeId}")
    void updateStatus(int employeeId);
    /*
    将部门调动后的部门号传到employee表中修改
     */
    @Update("update employee set department_id=#{transferDepartmentId} where employee_id=#{employeeId}")
    void updateDeparementId(DepartmentTransferInformation departmentTransferInformation);
    /*
    将岗位调动后的岗位号传到employee表中修改
     */
    @Update("update employee set position_id=#{transferPositionId} where employee_id=#{employeeId}")
    void updatePositionId(PositionTransferInformation positionTransferInformation);
    /*
    离职:将status改为2
     */
    @Update("update employee set status=2 where employee_id=#{employeeId}")
    void updateStatusTo2(DimissionInformation dimissionInformation);

    /**
     * 根据入职时间查询员工信息
     * @param reportDTO
     * @return
     */
    @Select("select employee_id, employee_name, gender, birth, identity_card, a.department_id, department_name," +
            "a.position_id, position_name ,enroll_date, work_date, employee_form, personnel_source, political_outlook," +
            " nation, origin, phone, email, height, blood_type, marital_status, birth_place, " +
            "household_registration_location, qualification, degree, graduate_school, major," +
            " graduate_date from employee a, department b, position c " +
            "where a.department_id = b.department_id and a.position_id = c.position_id " +
            "and enroll_date BETWEEN #{startTime} AND #{endTime} and status = 1")
    List<EnrollEmployeeVO> getByEnrollDate(ReportDTO reportDTO);

    /**
     * 根据离职时间查询员工信息
     * @param reportDTO
     * @return
     */
    @Select("select a.employee_id, employee_name, dimission_date, dimission_date, dimission_type, dimission_go, note from employee a, dimission_information b where a.employee_id = b.employee_id and dimission_date BETWEEN #{startTime} AND #{endTime} and status = 2")
    List<DimissionVO> getByDismissDate(ReportDTO reportDTO);

    /**
     * 根据部门调动时间获取员工数据
     * @param reportDTO
     * @return
     */
    @Select("select a.employee_id, employee_name, transfer_department_id, department_name, transfer_type, transfer_reason, transfer_date, note from employee a, department_transfer_information b, department c where a.employee_id = b.employee_id and b.transfer_department_id = c.department_id " +
            "and transfer_date BETWEEN #{startTime} AND #{endTime}")
    List<DepartmentTransferVO> getByDepartmentTransferDate(ReportDTO reportDTO);

    /**
     * 根据岗位调动时间获取员工数据
     * @param reportDTO
     * @return
     */
    @Select("select a.employee_id, employee_name, transfer_position_id, position_name, transfer_type, transfer_reason, transfer_date, note " +
            "from employee a, position_transfer_information b, position c where a.employee_id = b.employee_id and b.transfer_position_id = c.position_id " +
            "and transfer_date BETWEEN #{startTime} AND #{endTime}")
    List<PositionTransferVO> getByPositionTransferDate(ReportDTO reportDTO);


}
