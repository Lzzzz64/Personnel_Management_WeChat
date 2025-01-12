package com.jit.management.service;

import com.jit.management.mapper.DepartmentTransferInformationMapper;
import com.jit.management.mapper.DimissionInformationMapper;
import com.jit.management.pojo.DimissionInformation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class DimissionInformationServiceImpl implements DimissionInformationService{
    @Resource
    private DimissionInformationMapper dimissionInformationMapper;
    /*
    新增离职表数据
     */
    @Override
    public void insertDimissionInfo(DimissionInformation dimissionInformation) {
        dimissionInformationMapper.insertDimissionInfo(dimissionInformation);
    }
}
