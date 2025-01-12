package com.jit.management.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jit.management.mapper.RelationShipInformationMapper;
import com.jit.management.pojo.*;
import com.jit.management.result.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RelationShipInformationServiceImpl implements RelationShipInformationService{
    @Resource
    private RelationShipInformationMapper relationShipInformationMapper;
    /*
    分页查询关系表
     */
    @Override
    public PageResult pageQuery(CareerAndForeignAndRelationPageQueryDTO careerAndForeignAndRelationPageQueryDTO) {
        PageHelper.startPage(careerAndForeignAndRelationPageQueryDTO.getPage(),careerAndForeignAndRelationPageQueryDTO.getPageSize());
        Page<RelationShipInformationVO> page=relationShipInformationMapper.pageQuery(careerAndForeignAndRelationPageQueryDTO);
//        System.out.println(page);
        for(RelationShipInformationVO relationShipInformationVO : page.getResult()){
            int employeeId = relationShipInformationVO.getEmployeeId();
            relationShipInformationVO.setRelation(relationShipInformationMapper.getById(employeeId));
        }
        return new PageResult(page.getTotal(),page.getResult());
    }
    /**
     * 更新职业生涯
     * @param relationShipInformationVO
     */
    @Override
    public void update(RelationShipInformationVO relationShipInformationVO) {
        relationShipInformationMapper.deleteById(relationShipInformationVO.getEmployeeId());
        for(RelationshipInformation relationshipInformation : relationShipInformationVO.getRelation()){
            relationShipInformationMapper.insert(relationshipInformation);
        }
    }
    /**
     * 新增关系
     * @param relationshipInformation
     * @return
     */
    @Override
    public int insert(RelationshipInformation relationshipInformation) {
        return relationShipInformationMapper.insert(relationshipInformation);
    }
}
