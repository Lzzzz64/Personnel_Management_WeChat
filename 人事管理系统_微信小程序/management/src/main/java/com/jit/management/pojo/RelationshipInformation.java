package com.jit.management.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RelationshipInformation {
    private int employeeId; //员工号
    private String relationship; //与本人关系 父亲、母亲、配偶
    private String name; //姓名
    private String organization; //所在单位
    private String phone; //联系电话
}
