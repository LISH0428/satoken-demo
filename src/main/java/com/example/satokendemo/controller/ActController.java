package com.example.satokendemo.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.example.satokendemo.entity.User;
import com.example.satokendemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/do/")
public class ActController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/add")
    String add(User user) {
        if(StpUtil.hasPermission("add")){
            userMapper.insert(user);
            return "success";
        }
       return "fail";
    }
    @GetMapping("/delete")
   String deleteById(Integer id){
        if(StpUtil.hasPermission("add")){
            userMapper.deleteById(id);
            return "success";
        }
        return "fail";
    }
    @GetMapping("/search")
    String searchById(Integer id){
        User user = userMapper.selectById(id);
        return user.toString();
    }

}
