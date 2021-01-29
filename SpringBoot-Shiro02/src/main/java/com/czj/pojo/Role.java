package com.czj.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Role {

    private String role_id;
    private String role_name;
    private List<Permission> permissionList;
}
