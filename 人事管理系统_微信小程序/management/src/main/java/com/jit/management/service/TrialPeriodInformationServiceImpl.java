package com.jit.management.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jit.management.mapper.TrialPeriodInformationMapper;
import com.jit.management.pojo.EmployeeVO;
import com.jit.management.pojo.TrialPeriodPageQueryDTO;
import com.jit.management.pojo.TrialPeriodVO;
import com.jit.management.result.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class TrialPeriodInformationServiceImpl implements  TrialPeriodInformationService{
    @Resource
    private TrialPeriodInformationMapper trialPeriodInformationMapper;
    /*
    分页查询试用期员工
     */
    @Override
    public PageResult pageQuery(TrialPeriodPageQueryDTO trialPeriodPageQueryDTO) {
        System.out.println(trialPeriodPageQueryDTO);
        PageHelper.startPage(trialPeriodPageQueryDTO.getPage(),trialPeriodPageQueryDTO.getPageSize());
        Page<TrialPeriodVO> page=trialPeriodInformationMapper.pageQuery(trialPeriodPageQueryDTO);
        return new PageResult(page.getTotal(),page.getResult());
    }
    /*
    分页查询已转正员工
     */
    @Override
    public PageResult pageQuery1(TrialPeriodPageQueryDTO trialPeriodPageQueryDTO) {
        System.out.println(trialPeriodPageQueryDTO);
        PageHelper.startPage(trialPeriodPageQueryDTO.getPage(),trialPeriodPageQueryDTO.getPageSize());
        Page<TrialPeriodVO> page=trialPeriodInformationMapper.pageQuery1(trialPeriodPageQueryDTO);
        return new PageResult(page.getTotal(),page.getResult());
    }
    /*
    更新result信息
     */
    @Override
    public void updateResult(TrialPeriodVO trialPeriodVO) {
        trialPeriodInformationMapper.updateResult(trialPeriodVO);
    }
    /*
    更新试用员工信息
     */
    @Override
    public void updateTrialInformation(TrialPeriodVO trialPeriodVO) {
        trialPeriodInformationMapper.updateTrialInformation(trialPeriodVO);
    }
    /*
    员工入职时添加试用表信息:添加employeeId 和result=0
     */
    @Override
    public void insertTrialInformation(int employeeId) {
        trialPeriodInformationMapper.insertTrialInformation(employeeId);
    }
    /*
    直接添加员工入职时添加试用表信息:添加employeeId 和result=0
     */
    @Override
    public void insertTrialInformation1(EmployeeVO employeeVO) {
        trialPeriodInformationMapper.insertTrialInformation1(employeeVO);
    }
}
