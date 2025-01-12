package com.jit.management.service;

import com.jit.management.pojo.*;
import com.jit.management.result.PageResult;

public interface RelationShipInformationService {
    /*
    分页查询关系表
     */
    PageResult pageQuery(CareerAndForeignAndRelationPageQueryDTO careerAndForeignAndRelationPageQueryDTO);
    /**
     * 更新关系表
     * @param relationShipInformationVO
     */
    void update(RelationShipInformationVO relationShipInformationVO);
    /**
     * 新增关系
     * @param relationshipInformation
     * @return
     */
    int insert(RelationshipInformation relationshipInformation);
}
