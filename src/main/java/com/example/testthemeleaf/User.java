package com.example.testthemeleaf;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String name;
    private Integer age;
    private Date createTime;
}
