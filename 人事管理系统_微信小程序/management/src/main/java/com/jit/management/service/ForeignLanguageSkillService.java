package com.jit.management.service;

import com.jit.management.pojo.CareerAndForeignAndRelationPageQueryDTO;
import com.jit.management.pojo.ForeignLanguageSkill;
import com.jit.management.pojo.ForeignLanguageSkillVO;
import com.jit.management.result.PageResult;

public interface ForeignLanguageSkillService {
    /*
    分页查询外语能力
     */
    PageResult pageQuery(CareerAndForeignAndRelationPageQueryDTO careerAndForeignAndRelationPageQueryDTO);

    /**
     * 更新外语能力
     * @param foreignLanguageSkillVO
     * @return
     */
    void update(ForeignLanguageSkillVO foreignLanguageSkillVO);

    /**
     * 新增职业生涯
     * @param foreignLanguageSkill
     * @return
     */
    int insert(ForeignLanguageSkill foreignLanguageSkill);
}
