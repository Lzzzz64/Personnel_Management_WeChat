package com.jit.management.controller;

import com.jit.management.pojo.*;
import com.jit.management.result.PageResult;
import com.jit.management.result.Result;
import com.jit.management.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("relation")
@Slf4j
public class RelationShipInformationController {
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
    分页查询关系表
     */
    @GetMapping("/page")
    public Result pageQuery(CareerAndForeignAndRelationPageQueryDTO careerAndForeignAndRelationPageQueryDTO){
        PageResult pageResult=relationShipInformationService.pageQuery(careerAndForeignAndRelationPageQueryDTO);
        return Result.success(pageResult);
    }
    /**
     * 更新关系
     * @param relationShipInformationVO
     * @return
     */
    @PutMapping()
    public Result update(@RequestBody RelationShipInformationVO relationShipInformationVO){
        relationShipInformationService.update(relationShipInformationVO);
        return Result.success();
    }
    @PostMapping()
    public Result insert(@RequestBody RelationshipInformation relationshipInformation){
        int flag = relationShipInformationService.insert(relationshipInformation);
        if(flag == 1) return Result.success();
        else return Result.error("添加失败");
    }
}
