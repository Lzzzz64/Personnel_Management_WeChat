package com.jit.management.controller;

import com.jit.management.pojo.Department;
import com.jit.management.pojo.DepartmentPageQueryDTO;
import com.jit.management.result.PageResult;
import com.jit.management.result.Result;
import com.jit.management.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("department")
@Slf4j
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/page")
    public Result findAllDepartment(DepartmentPageQueryDTO departmentPageQueryDTO) {
        PageResult pageResult = departmentService.findAllDepartment(departmentPageQueryDTO);
        return Result.success(pageResult);
    }
    @PutMapping("/update")
    public Result Update(@RequestBody Department department) {
        int result = departmentService.updateDepartment(department);
        if(result==1) return Result.success();
        else return Result.error("更新失败");
    }
    @PostMapping()
    public Result Insert(@RequestBody Department department) {
        int result = departmentService.insertDepartment(department);
        if(result==1) return Result.success();
        else return Result.error("插入失败");
    }

    @DeleteMapping()
    public Result delete(int departmentId) {
        int result = departmentService.deleteDepartment(departmentId);
        if(result==1) return Result.success();
        else return Result.error("删除失败");
    }


}
