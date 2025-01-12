package com.jit.management.mapper;

import com.github.pagehelper.Page;
import com.jit.management.pojo.Department;
import com.jit.management.pojo.DepartmentPageQueryDTO;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DepartmentMapper {
    //查看部门全部信息
    //@Select("SELECT department_id departmentId,department_name departmentName FROM department")
    public Page<Department> findAllDepartment(DepartmentPageQueryDTO departmentPageQueryDTO);

    //查看单个部门的信息
    @Select("select * from department where department_id=#{departmentId}")
    public Department findDepartment(int departmentId);

    @Insert("insert into department(department_id,department_name) values (#{departmentId},#{departmentName})")
    //插入（新增）部门信息
    public int  insertDepartment(Department department);

    @Update("update department set department_name=#{departmentName} where department_id=#{departmentId}")
    //修改部门信息
    public int  updateDepartment(Department department);

    @Delete("delete from department where department_id=#{departmentId}")
    //删除部门信息
    public int deleteDepartment(int departmentId);


}
