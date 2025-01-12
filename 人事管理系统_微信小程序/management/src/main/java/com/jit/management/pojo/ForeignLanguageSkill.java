package com.jit.management.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ForeignLanguageSkill {
    private int employeeId; //员工号
    private String type; //外国语种
    private int proficiency; //外国语种熟练程度 0 完全不懂 1 少量，不能进行业务沟通 2 有限的业务沟通 3 一般，业务沟通仍受少量限制 4 好， 无困难地进行谈判和讲演 5 流利，在商务中自如地运用
}
