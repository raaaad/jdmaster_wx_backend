package com.smartbackend.controller;

import com.smartbackend.model.User;
import com.smartbackend.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;

    @RequestMapping("getUserById")
    public String getUser(HttpServletRequest request, org.springframework.ui.Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        model.addAttribute("user",user);
        return "User";
    }
}
