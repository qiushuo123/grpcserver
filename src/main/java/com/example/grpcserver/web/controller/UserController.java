package com.example.grpcserver.web.controller;

import com.example.grpcserver.domain.User;
import com.example.grpcserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/showUser")
    @ResponseBody
    public User toIndex(HttpServletRequest request, Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        return user;
    }

    @RequestMapping("/updateusername")
    @ResponseBody
    public User updateUsername(HttpServletRequest request, Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        int age=-1;
        if(request.getParameter("age")!=null) {
            age = Integer.parseInt(request.getParameter("age"));
        }
        userService.updateUsername(userId,username,age);
        User user = this.userService.getUserById(userId);
        return user;
    }
}
