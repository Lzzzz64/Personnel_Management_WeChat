package com.jit.management.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jit.management.mapper.EmployeeMapper;
import com.jit.management.pojo.*;
import com.jit.management.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
    @Resource
    private EmployeeMapper employeeMapper;
    /*
    将岗位调动后的岗位号传到employee表中修改
     */
    @Override
    public void updatePositionId(PositionTransferInformation positionTransferInformation) {
        employeeMapper.updatePositionId(positionTransferInformation);
    }

    /*
     将部门调动后的部门号传到employee表中修改
    */
    @Override
    public void updateDeparementId(DepartmentTransferInformation departmentTransferInformation) {
        employeeMapper.updateDeparementId(departmentTransferInformation);
    }

    /*
    分页查询
    查询员工未入职信息
     */
    @Override
    public PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO) {
        PageHelper.startPage(employeePageQueryDTO.getPage(),employeePageQueryDTO.getPageSize());
        Page<EmployeeVO> page=employeeMapper.pageQuery(employeePageQueryDTO);
        return new PageResult(page.getTotal(),page.getResult());
    }
/*
分页查询
查询员工已入职信息
 */
    public PageResult pageQuery1(EmployeePageQueryDTO employeePageQueryDTO){
        PageHelper.startPage(employeePageQueryDTO.getPage(),employeePageQueryDTO.getPageSize());
        Page<EmployeeVO> page=employeeMapper.pageQuery1(employeePageQueryDTO);
        return new PageResult(page.getTotal(),page.getResult());
    }
    /*
    新增员工入职
     */
    @Override
    public void insertEmployee(EmployeeVO employeeVO) {
    employeeMapper.AddEmployee(employeeVO);
    }

/*
查询员工入职信息
根据employeeId
 */
    @Override
    public Employee information(int employeeId) {
    Employee employee=employeeMapper.FindEmployeeById(employeeId);
    return employee;
    }
/*
修改员工信息
 */
    @Override
    public void update(EmployeeVO employeeVO) {
        employeeMapper.update(employeeVO);
    }

    /*
    将员工入职
     */
    @Override
    public void updateStatus(int employeeId) {
        employeeMapper.updateStatus(employeeId);
    }
    /*
    离职:将status改为2
     */
    @Override
    public void updateStatusTo2(DimissionInformation dimissionInformation) {
        employeeMapper.updateStatusTo2(dimissionInformation);
    }

    /**
     * 根据入职时间查询员工信息
     * @param reportDTO
     * @return
     */
    @Override
    public List<EnrollEmployeeVO> getByEnrollDate(ReportDTO reportDTO) {
        return employeeMapper.getByEnrollDate(reportDTO);
    }

    /**
     * 根据离职时间获取员工数据
     * @param reportDTO
     * @return
     */
    @Override
    public List<DimissionVO> getByDismissDate(ReportDTO reportDTO) {
        return employeeMapper.getByDismissDate(reportDTO);
//        return null;
    }

    /**
     * 根据部门调动时间获取员工数据
     * @param reportDTO
     * @return
     */
    @Override
    public List<DepartmentTransferVO> getByDepartmentTransferDate(ReportDTO reportDTO) {
        return employeeMapper.getByDepartmentTransferDate(reportDTO);
    }

    /**
     * 根据岗位调动时间获取员工数据
     * @param reportDTO
     * @return
     */
    @Override
    public List<PositionTransferVO> getByPositionTransferDate(ReportDTO reportDTO) {
        return employeeMapper.getByPositionTransferDate(reportDTO);
    }

}
