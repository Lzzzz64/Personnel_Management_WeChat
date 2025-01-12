package com.jit.management.controller;

import com.jit.management.pojo.CareerAndForeignAndRelationPageQueryDTO;
import com.jit.management.pojo.ForeignLanguageSkill;
import com.jit.management.pojo.ForeignLanguageSkillVO;
import com.jit.management.result.PageResult;
import com.jit.management.result.Result;
import com.jit.management.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("foreign")
@Slf4j
public class ForeignLanguageSkillController {
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
    分页查询外语能力
     */
    @GetMapping("/page")
    public Result pageQuery(CareerAndForeignAndRelationPageQueryDTO careerAndForeignAndRelationPageQueryDTO){
        PageResult pageResult= foreignLanguageSkillService.pageQuery(careerAndForeignAndRelationPageQueryDTO);
        System.out.println(pageResult);
        return Result.success(pageResult);
    }

    /**
     * 更新外语能力
     * @param foreignLanguageSkillVO
     * @return
     */
    @PutMapping()
    public Result update(@RequestBody ForeignLanguageSkillVO foreignLanguageSkillVO){
        foreignLanguageSkillService.update(foreignLanguageSkillVO);
        return Result.success();
    }

    /**
     * 新增职业生涯
     * @param foreignLanguageSkill
     * @return
     */
    @PostMapping()
    public Result insert(@RequestBody ForeignLanguageSkill foreignLanguageSkill){
        int flag = foreignLanguageSkillService.insert(foreignLanguageSkill);
        if(flag == 1) return Result.success();
        else return Result.error("添加失败");
    }
}
