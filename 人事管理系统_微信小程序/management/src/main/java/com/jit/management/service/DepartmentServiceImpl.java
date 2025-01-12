package com.jit.management.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jit.management.mapper.DepartmentMapper;
import com.jit.management.pojo.Department;
import com.jit.management.pojo.DepartmentPageQueryDTO;
import com.jit.management.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    //管理员查看全部部门信息
    public PageResult findAllDepartment(DepartmentPageQueryDTO departmentPageQueryDTO) {
        PageHelper.startPage(departmentPageQueryDTO.getPage(), departmentPageQueryDTO.getPageSize());
        Page<Department> page=departmentMapper.findAllDepartment(departmentPageQueryDTO);
        return new PageResult(page.getTotal(),page.getResult());
    }

    //管理员查看单个部门信息
    public Department findDepartment(int departmentId) {
        Department department =  departmentMapper.findDepartment(departmentId);
        return department;
    }
    //管理员插入（新增）部门信息
    public int insertDepartment(Department department) {
        int id=department.getDepartmentId();
        if(departmentMapper.findDepartment(id)!=null)
            return 0;
        return departmentMapper.insertDepartment(department);
    }

    //管理员修改部门信息
    public int updateDepartment(Department department) {
        return departmentMapper.updateDepartment(department);
    }

    //管理员删除部门信息
    public int deleteDepartment(int departmentId) {
        return departmentMapper.deleteDepartment(departmentId);
    }
}
