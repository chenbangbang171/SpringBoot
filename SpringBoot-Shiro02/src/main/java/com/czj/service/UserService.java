package com.czj.service;

import com.czj.pojo.Permission;
import com.czj.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    List<Permission> queryAllPermission(int userid);

    List<String> queryAllPermissionsByUserName(String userName);

    User queryUserByNameAndPwd(String userName, String userPwd);


}
