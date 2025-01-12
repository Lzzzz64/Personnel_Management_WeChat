package com.jit.management.service;


import com.jit.management.mapper.AdminMapper;
import com.jit.management.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    //管理员登录
    public int login(Admin admin) {
        Admin admin1 = adminMapper.login(admin);
        if(admin1 == null) return 0;
        return 1;
    }
}
