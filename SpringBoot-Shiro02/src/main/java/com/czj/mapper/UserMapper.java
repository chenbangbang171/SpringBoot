package com.czj.mapper;

import com.czj.pojo.Permission;
import com.czj.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
        List<Permission> queryAllPermissionsByUserId(int id);

        List<String> queryAllPermissionsByUserName(String userName);

        User queryUserByNameAndPwd(@Param("userName") String userName, @Param("userPwd") String userPwd);//两个参数的sql需要注解

}
