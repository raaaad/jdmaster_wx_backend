package com.smartbackend.controller;

import com.smartbackend.model.Recruiter;
import com.smartbackend.service.IRecruiterService;
import com.smartbackend.utils.ObjectUtil;
import com.smartbackend.utils.Resp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/recruiter")
public class RecruiterController {
    @Resource
    private IRecruiterService recruiterService;

    @RequestMapping("register")
    @ResponseBody
    public Resp addRecruiter(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        //获取微信小程序get的参数值并打印
        String company = request.getParameter("company");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String wechat = request.getParameter("wechat");
        this.recruiterService.insertRecruiter(company,telephone,email,wechat);

        //返回值给微信小程序
        //Writer out = response.getWriter();
        //out.write("恭喜您，已成功注册！");
        //out.flush();

        Resp resp = new Resp(true,"已成功注册！");
        return resp;
    }

    @RequestMapping("login")
    @ResponseBody
    public Resp recruiterLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String wechat = request.getParameter("wechat");
        Recruiter recruiter = this.recruiterService.getRecruiterByWechat(wechat);
        if(ObjectUtil.isNullOrEmpty(recruiter)){
            Resp resp = new Resp(false,"请注册！");
            return resp;
        }else {
            Resp resp = new Resp(true,"登陆成功");
            return resp;
        }
    }

    @RequestMapping("getRecruiterInfo")
    @ResponseBody
    public Recruiter getRecruiterInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String wechat = request.getParameter("wechat");
        Recruiter recruiter = this.recruiterService.getRecruiterByWechat(wechat);
        return recruiter;
    }

}
