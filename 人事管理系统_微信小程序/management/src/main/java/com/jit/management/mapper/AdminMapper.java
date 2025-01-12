package com.jit.management.mapper;


import com.jit.management.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {
    @Select("select * from admin where admin_id = #{adminId} and admin_pwd = #{adminPwd}")
    public Admin login(Admin admin);
}
