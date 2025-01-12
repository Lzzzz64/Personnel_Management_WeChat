package com.jit.management;

import com.jit.management.pojo.Admin;
import com.jit.management.pojo.Employee;
import com.jit.management.pojo.EmployeePageQueryDTO;
import com.jit.management.result.PageResult;
import com.jit.management.service.AdminService;
import com.jit.management.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ManagementApplicationTests {
    @Autowired
    AdminService adminService;
    @Autowired
    private EmployeeService employeeService;
    @Test
    void loginTest() {
        int flag = adminService.login(new Admin("admin", "123"));
        System.out.println(flag);
    }
    @Test
    void employee() {
        int flag = adminService.login(new Admin("admin", "123"));
        Employee employee=employeeService.information(10001);
        System.out.println(employee);
    }
    @Test
    void employee1() {
        int flag = adminService.login(new Admin("admin", "123"));
        Employee employee=employeeService.information(10001);
        System.out.println(employee);
    }
}
