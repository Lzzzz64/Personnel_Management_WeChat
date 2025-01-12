package com.jit.management.pojo;

import lombok.Data;

@Data
public class PositionPageQueryDTO {
    private String PositionId; //岗位编号
    private String PositionName; //岗位名称
    private int page; //当前页码
    private int pageSize; //一页显示多少条

    public String getPositionId() {
        return PositionId;
    }

    public void setPositionId(String positionId) {
        PositionId = positionId;
    }

    public String getPositionName() {
        return PositionName;
    }

    public void setPositionName(String positionName) {
        PositionName = positionName;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
