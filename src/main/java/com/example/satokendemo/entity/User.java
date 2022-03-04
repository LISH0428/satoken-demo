package com.example.satokendemo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("user")
@Data
public class User {
    @TableId
    private Integer id;
    private String name;
    private String password;
    private String info;
    private String roleName;
}
