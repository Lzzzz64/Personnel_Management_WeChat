package com.jit.management.service;

import com.jit.management.mapper.PositionTransferInformationMapper;
import com.jit.management.pojo.PositionTransferInformation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class PositionTransferInformationServiceImpl implements PositionTransferInformationService{
    @Resource
    private PositionTransferInformationMapper positionTransferInformationMapper;
    @Override
    /*
    新增岗位调动表
     */
    public void addToPosition(PositionTransferInformation positionTransferInformation) {
        positionTransferInformationMapper.addToPosition(positionTransferInformation);
    }
}
