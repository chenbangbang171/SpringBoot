package com.czj.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class User {
    @TableField("user_id")
    private int user_id;

    @TableField("user_name")
    private String user_name;

    @TableField("user_pwd")
    private String user_pwd;

    @TableField("user_role_id")
    private int user_role_id;
}
