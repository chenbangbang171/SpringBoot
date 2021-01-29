package com.czj.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {
    @TableId(type = IdType.NONE)
    @TableField("id")
    private String id;

    @TableField("userName")
    private String userName;

    @TableField("password")
    private String passWord;

    @TableField("email")
    private String email;

    @TableField("gender")
    private String gender;

    @TableField("flag")
    private String flag;

    @TableField("role")
    private String role;

    @TableField("code")
    private String code;




}
