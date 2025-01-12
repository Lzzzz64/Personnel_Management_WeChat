package com.jit.management.mapper;

import com.jit.management.pojo.PositionTransferInformation;
import org.apache.ibatis.annotations.Insert;

public interface PositionTransferInformationMapper {
    /*
    新增岗位调动表
     */
    @Insert("insert into position_transfer_information(employee_id, transfer_position_id, transfer_type, transfer_reason, transfer_date, note) values (#{employeeId},#{transferPositionId},#{transferType},#{transferReason},#{transferDate},#{note})")
    void addToPosition(PositionTransferInformation positionTransferInformation);
}
