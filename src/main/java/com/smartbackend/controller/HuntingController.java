package com.smartbackend.controller;

import com.smartbackend.model.Job;
import com.smartbackend.service.IHuntingService;
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
@RequestMapping("/hunting")
public class HuntingController {
    @Resource
    private IHuntingService huntingService;

    @RequestMapping("viewJob")
    @ResponseBody
    public Resp viewJob(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String wechat = request.getParameter("wechat");
        Integer jobId = Integer.parseInt(request.getParameter("jobId"));
        Resp resp;
        if(this.huntingService.addView(wechat,jobId)==1){
            resp = new Resp(true,"用户初次浏览！");
            return resp;
        }
        resp = new Resp(true,"用户已浏览过！");
        return resp;
    }

    @RequestMapping("followJob")
    @ResponseBody
    public Resp followJob(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String wechat = request.getParameter("wechat");
        Integer jobId = Integer.parseInt(request.getParameter("jobId"));
        //判断用户是否已关注该JD
        //添加关注
        Resp resp = new Resp(true,"已关注");
        return resp;
    }
}
