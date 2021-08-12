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

    List<User> queryAllUsers();//查询所有用户

    int deleteUserByUserId(int id);//根据用户id删除用户

    int updateUserByUserId(User user);//根据用户id修改用户信息

    User queryUserByEmail(String email); //根据用户邮箱查询用户


}
