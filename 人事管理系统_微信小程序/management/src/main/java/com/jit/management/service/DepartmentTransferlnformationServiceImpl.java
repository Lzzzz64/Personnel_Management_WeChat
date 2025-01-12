package com.jit.management.service;

import com.jit.management.mapper.DepartmentTransferInformationMapper;
import com.jit.management.pojo.DepartmentTransferInformation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional

public class DepartmentTransferlnformationServiceImpl implements DepartmentTransferlnformationService{
    @Resource
    private DepartmentTransferInformationMapper departmentTransferInformationMapper;

    /*
    新增部门调动表
     */
    @Override
    public void addToDepartment(DepartmentTransferInformation departmentTransferInformation) {
        departmentTransferInformationMapper.addToDepartment(departmentTransferInformation);
    }
}
