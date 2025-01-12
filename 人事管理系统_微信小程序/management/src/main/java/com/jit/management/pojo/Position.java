package com.jit.management.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    private int positionId; //岗位编号
    private String positionName; //岗位名称
    private String positionType; //岗位类型
    private String positionNum; //岗位编制，配置人数

}
