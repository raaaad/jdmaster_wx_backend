package com.smartbackend.controller;

import com.smartbackend.model.Trainee;
import com.smartbackend.service.IRecruiterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Controller
@RequestMapping("/recruiter")
public class RecruiterController {
    @Resource
    private IRecruiterService recruiterService;

    @RequestMapping("addRecruiter")
    public void getAllTrainees(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        //获取微信小程序get的参数值并打印
        String company = request.getParameter("company");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String wechat = "InterfaceTest";
        this.recruiterService.insertRecruiter(company,telephone,email,wechat);

        //返回值给微信小程序
        Writer out = response.getWriter();
        out.write("恭喜您，已成功注册！");
        out.flush();
    }

}
