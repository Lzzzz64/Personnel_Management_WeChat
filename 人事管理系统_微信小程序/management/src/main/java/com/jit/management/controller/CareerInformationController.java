package com.jit.management.controller;

import com.jit.management.pojo.CareerAndForeignAndRelationPageQueryDTO;
import com.jit.management.pojo.CareerInformation;
import com.jit.management.pojo.CareerInformationVO;
import com.jit.management.result.PageResult;
import com.jit.management.result.Result;
import com.jit.management.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("career")
@Slf4j
public class CareerInformationController {
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
    分页查询职业生涯信息
     */
    @GetMapping("/page")
    public Result pageQuery(CareerAndForeignAndRelationPageQueryDTO careerInformationDTO){
        PageResult pageResult=careerInformationService.pageQuery(careerInformationDTO);
        return Result.success(pageResult);
    }

    /**
     * 更新事业生涯
     * @param careerInformationVO
     * @return
     */
    @PutMapping()
    public Result update(@RequestBody CareerInformationVO careerInformationVO){
        careerInformationService.update(careerInformationVO);
        return Result.success();
    }

    /**
     * 新增职业生涯
     * @param careerInformation
     * @return
     */
    @PostMapping()
    public Result insert(@RequestBody CareerInformation careerInformation){
        int flag = careerInformationService.insert(careerInformation);
        if(flag == 1) return Result.success();
        else return Result.error("添加失败");
    }
}
