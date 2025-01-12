package com.jit.management.service;

import com.jit.management.pojo.Department;
import com.jit.management.pojo.DepartmentPageQueryDTO;
import com.jit.management.result.PageResult;

public interface DepartmentService {
    //部门全部信息的查找
    public PageResult findAllDepartment(DepartmentPageQueryDTO departmentPageQueryDTO);

    //单个部门信息的查找
    public Department findDepartment(int departmentId);

    //部门信息的插入
    public int insertDepartment(Department department);

    //部门信息的修改
    public int updateDepartment(Department department);

    //部门信息的删除
    public int deleteDepartment(int departmentId);
}
