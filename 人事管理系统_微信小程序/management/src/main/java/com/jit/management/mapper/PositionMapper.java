package com.jit.management.mapper;

import com.github.pagehelper.Page;
import com.jit.management.pojo.Position;
import com.jit.management.pojo.PositionPageQueryDTO;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PositionMapper {
    //查看岗位全部信息
    public Page<Position> findAllPosition(PositionPageQueryDTO positionPageQueryDTO);

    //查看单个岗位信息
    @Select("select * from position where position_id=#{positionId}")
    public Position findPosition(int positionId);

    //插入岗位信息
   @Insert("insert into position (position_id,position_name,position_type,position_num) values (#{positionId},#{positionName},#{positionType},#{positionNum})")
    public int insertPosition(Position position);

    //修改岗位信息
    @Update("update position set position_name=#{positionName},position_type=#{positionType},position_num=#{positionNum} where position_id=#{positionId}")
    public int updatePosition(Position position);

    //删除岗位信息
    @Delete("delete from position where position_id=#{positionId}")
    public int deletePosition(int positionId);


}
