package com.jit.management.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jit.management.mapper.PositionMapper;
import com.jit.management.pojo.Position;
import com.jit.management.pojo.PositionPageQueryDTO;
import com.jit.management.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionMapper positionMapper;

    public PageResult findAllPosition(PositionPageQueryDTO positionPageQueryDTO) {
        PageHelper.startPage(positionPageQueryDTO.getPage(),positionPageQueryDTO.getPageSize());
        Page<Position> page=positionMapper.findAllPosition(positionPageQueryDTO);
        return new PageResult(page.getTotal(),page.getResult());
    }

    public Position findPosition(int positionId) {
        return positionMapper.findPosition(positionId);
    }

    public int insertPosition(Position position) {
        return positionMapper.insertPosition(position);
    }
    public int updatePosition(Position position) {
        return positionMapper.updatePosition(position);
    }

    public int deletePosition(int positionId) {
        return positionMapper.deletePosition(positionId);
    }
}
