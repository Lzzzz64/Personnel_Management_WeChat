package com.jit.management.controller;

import com.jit.management.pojo.*;
import com.jit.management.result.PageResult;
import com.jit.management.result.Result;
import com.jit.management.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employee")
@Slf4j
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private TrialPeriodTimeService trialPeriodTimeService;
    @Autowired
    private DepartmentTransferlnformationService departmentTransferlnformationService;
    @Autowired
    private PositionTransferInformationService positionTransferInformationService;
    @Autowired
    private DimissionInformationService dimissionInformationService;
    @Autowired
    private TrialPeriodInformationService trialPeriodInformationService;
    @Autowired
    private CareerInformationService careerInformationService;
    @Autowired
    private ForeignLanguageSkillService foreignLanguageSkillService;
    @Autowired
    private RelationShipInformationService relationShipInformationService;
    /*
    分页查询未入职的员工
     */
    @GetMapping("/page")
    public Result pageQuery(EmployeePageQueryDTO employeePageQueryDTO){
        PageResult pageResult=employeeService.pageQuery(employeePageQueryDTO);
        return Result.success(pageResult);
    }
    /*
    分页查询已入职的员工
     */
    @GetMapping("/page1")
    public Result pageQuery1( EmployeePageQueryDTO employeePageQueryDTO){
        PageResult pageResult=employeeService.pageQuery1(employeePageQueryDTO);
        return Result.success(pageResult);
    }
/*
新增员工入职
添加员工入职过程中试用期表
直接添加员工入职时添加试用表信息:添加employeeId 和result=0
 */
    @PostMapping("/insert")
    public Result insertEmployee(@RequestBody EmployeeVO employeeVO){
        employeeService.insertEmployee(employeeVO);
        trialPeriodTimeService.insertTrialPeriodTime(employeeVO);
        trialPeriodInformationService.insertTrialInformation1(employeeVO);
        return Result.success();
}
/*
查询入职员工
根据employeeId
 */
    @GetMapping
    public Result information(int employeeId){
        Employee employee=employeeService.information(employeeId);
        return Result.success(employee);
    }

    /*
    修改员工信息
    修改试用期
     */
    @PutMapping("/update")
    public Result update(@RequestBody EmployeeVO employeeVO){
        Employee employee = new Employee();
        TrialPeriodTime trialPeriodTime = new TrialPeriodTime();
        BeanUtils.copyProperties(employeeVO,employee);
        BeanUtils.copyProperties(employeeVO,trialPeriodTime);
        employeeService.update(employeeVO);
        trialPeriodTimeService.update(trialPeriodTime);
        return Result.success();
    }

    /*
    入职,status改为1
    员工入职时添加试用表信息:添加employeeId 和result=0
     */
    @GetMapping("/updateStatus")
    public Result updateStatus(int employeeId){
        employeeService.updateStatus(employeeId);
        trialPeriodInformationService.insertTrialInformation(employeeId);
        return Result.success();
    }
    /*
    新增部门调动
    将部门调动后的部门号传到employee表中修改
     */
    @PutMapping("/InsertDepartment")
    public Result AddDepartment(@RequestBody DepartmentTransferInformation departmentTransferInformation){
        departmentTransferlnformationService.addToDepartment(departmentTransferInformation);
        employeeService.updateDeparementId(departmentTransferInformation);
        return Result.success();
    }
    /*
    新增岗位调动表
    将岗位调动后的岗位号传到employee表中修改
     */
    @PutMapping("/InsertPosition")
    public Result AddPosition(@RequestBody PositionTransferInformation positionTransferInformation){
        positionTransferInformationService.addToPosition(positionTransferInformation);
        employeeService.updatePositionId(positionTransferInformation);
        return Result.success();
    }
    /*
    新增离职表数据
    将employee中status改为2
     */
    @PutMapping("/InsertDimissionInfo")
    public Result insertDimissionInfo(@RequestBody DimissionInformation dimissionInformation){
        dimissionInformationService.insertDimissionInfo(dimissionInformation);
        employeeService.updateStatusTo2(dimissionInformation);
        return Result.success();
    }
}
