package com.jit.management.controller;

import com.jit.management.pojo.TrialPeriodPageQueryDTO;
import com.jit.management.pojo.TrialPeriodVO;
import com.jit.management.result.PageResult;
import com.jit.management.result.Result;
import com.jit.management.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("trialPeriod")
@Slf4j
public class TrialPeriodInformationController {
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
    分页查询试用期员工
     */
    @GetMapping("/page")
    public Result pageQuery(TrialPeriodPageQueryDTO trialPeriodPageQueryDTO){
        PageResult pageResult=trialPeriodInformationService.pageQuery(trialPeriodPageQueryDTO);
        return Result.success(pageResult);
    }
    /*
   分页查询已转正员工
    */
    @GetMapping("/page1")
    public Result pageQuery1(TrialPeriodPageQueryDTO trialPeriodPageQueryDTO){
        PageResult pageResult=trialPeriodInformationService.pageQuery1(trialPeriodPageQueryDTO);
        return Result.success(pageResult);
    }
    /*
    更新result信息
     */
    @PutMapping("/update")
    public Result updateResult(@RequestBody TrialPeriodVO trialPeriodVO){
        trialPeriodInformationService.updateTrialInformation(trialPeriodVO);
        return Result.success();
    }
}
