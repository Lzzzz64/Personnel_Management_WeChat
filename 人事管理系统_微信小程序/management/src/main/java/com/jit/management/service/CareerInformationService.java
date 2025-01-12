package com.jit.management.service;

import com.jit.management.pojo.CareerAndForeignAndRelationPageQueryDTO;
import com.jit.management.pojo.CareerInformation;
import com.jit.management.pojo.CareerInformationVO;
import com.jit.management.result.PageResult;

public interface CareerInformationService {
    PageResult pageQuery(CareerAndForeignAndRelationPageQueryDTO careerInformationDTO);

    /**
     * 更新职业生涯
     * @param careerInformationVO
     */
    void update(CareerInformationVO careerInformationVO);

    /**
     * 新增职业生涯
     * @param careerInformation
     * @return
     */
    int insert(CareerInformation careerInformation);
}
