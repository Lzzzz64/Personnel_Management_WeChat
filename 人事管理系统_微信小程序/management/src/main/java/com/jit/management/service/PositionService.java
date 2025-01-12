package com.jit.management.service;

import com.jit.management.pojo.Position;
import com.jit.management.pojo.PositionPageQueryDTO;
import com.jit.management.result.PageResult;

public interface PositionService {
    //查看全部岗位信息
    public PageResult findAllPosition(PositionPageQueryDTO positionPageQueryDTO);

    //查找单个岗位信息
    public Position findPosition(int positionId);

    //插入岗位信息
    public int insertPosition(Position position);

    //修改岗位信息
    public int updatePosition(Position position);

    //删除岗位信息
    public int deletePosition(int positionId);
}
