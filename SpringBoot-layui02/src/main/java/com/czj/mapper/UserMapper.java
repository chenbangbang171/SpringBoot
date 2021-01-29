package com.czj.mapper;

import com.czj.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User login(@Param("phone") String phone,@Param("pwd") String pwd);
}
