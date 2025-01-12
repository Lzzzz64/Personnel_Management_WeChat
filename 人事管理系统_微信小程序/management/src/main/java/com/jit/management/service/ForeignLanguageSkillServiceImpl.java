package com.jit.management.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jit.management.mapper.ForeignLanguageSkillMapper;
import com.jit.management.pojo.*;
import com.jit.management.result.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ForeignLanguageSkillServiceImpl implements ForeignLanguageSkillService {
    @Resource
    private ForeignLanguageSkillMapper foreignLanguageSkillMapper;
    /*
    分页查询外语能力
     */
    @Override
    public PageResult pageQuery(CareerAndForeignAndRelationPageQueryDTO careerAndForeignAndRelationPageQueryDTO) {
        PageHelper.startPage(careerAndForeignAndRelationPageQueryDTO.getPage(),careerAndForeignAndRelationPageQueryDTO.getPageSize());
        Page<ForeignLanguageSkillVO> page=foreignLanguageSkillMapper.pageQuery(careerAndForeignAndRelationPageQueryDTO);
        for(ForeignLanguageSkillVO foreignLanguageSkillVO : page.getResult()){
            int employeeId = foreignLanguageSkillVO.getEmployeeId();
            foreignLanguageSkillVO.setForeign(foreignLanguageSkillMapper.getById(employeeId));
        }
        return new PageResult(page.getTotal(),page.getResult());
    }

    /**
     * 更新外语能力
     * @param foreignLanguageSkillVO
     * @return
     */
    @Override
    public void update(ForeignLanguageSkillVO foreignLanguageSkillVO) {
        foreignLanguageSkillMapper.deleteById(foreignLanguageSkillVO.getEmployeeId());
        for(ForeignLanguageSkill foreignLanguageSkill : foreignLanguageSkillVO.getForeign()){
            foreignLanguageSkillMapper.insert(foreignLanguageSkill);
        }
    }

    /**
     * 新增职业生涯
     * @param foreignLanguageSkill
     * @return
     */
    @Override
    public int insert(ForeignLanguageSkill foreignLanguageSkill) {
        return foreignLanguageSkillMapper.insert(foreignLanguageSkill);
    }
}
