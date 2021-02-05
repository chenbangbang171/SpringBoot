package com.czj.mapper;

import com.czj.pojo.Permission;
import com.czj.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    User login(@Param("phone") String phone,@Param("pwd") String pwd);

    List<Permission> queryAllPermissionsByUserId(int id);

    List<String> queryAllPermissionsByUserName(String userName);
}
