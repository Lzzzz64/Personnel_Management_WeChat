package com.jit.management.controller;

import com.jit.management.pojo.Admin;
import com.jit.management.result.Result;
import com.jit.management.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/login")
    public int login(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
//        System.out.println(admin);
//        int res = adminService.login(admin);
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("name");
        String password = request.getParameter("password");

        if (adminService.login(new Admin(username, password)) != 0) {
            //session.setAttribute("username",username);
            return 1;
        } else {
            //model.addAttribute("msg","用户名或密码错误！");
            return 0;
        }
    }
}
//        if(res == 0) return Result.error("账号密码错误");
//                else return Result.success();
//    }
//}
//
//    public int userLogin(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
//        //
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
//
//        String username = request.getParameter("name");
//        String password = request.getParameter("password");
//        //
//        if(adminService.LoginService(username,password)!=0){
//            //session.setAttribute("username",username);
//            return 1;
//        }else{
//            //model.addAttribute("msg","用户名或密码错误！");
//            return 0;
//        }