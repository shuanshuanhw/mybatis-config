package com.example.mybatisconfig.domain;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String userId;
    private String userName;
    private String password;
    private String email;

}
