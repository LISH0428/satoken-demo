package com.example.satokendemo.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.example.satokendemo.entity.User;
import com.example.satokendemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    UserMapper userMapper;
    @GetMapping("/login")
    public String login(String name,String password){
       Map<String,Object> map=new HashMap<String,Object>();
       map.put("name", name);
        User user = userMapper.selectByMap(map).get(0);
        String realPassword = user.getPassword();
        if(password.equals(realPassword)){
            StpUtil.login(user.getRoleName());

            System.out.println("loginId"+StpUtil.getLoginId());
            System.out.println("permissionList"+StpUtil.getPermissionList());
            return "OK";
        }
        return "Failure";
    }

}
