package com.jit.management.pojo;

import lombok.Data;

@Data
public class DepartmentPageQueryDTO {
    private String departmentId; //部门编号
    private String departmentName; //部门名称
    private int page; //当前页码
    private int pageSize; //一页显示多少条

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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
