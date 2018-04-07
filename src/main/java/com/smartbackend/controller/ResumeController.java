package com.smartbackend.controller;

import com.smartbackend.model.Resume;
import com.smartbackend.service.IResumeService;
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
import java.util.List;

@Controller
@RequestMapping("/resume")
public class ResumeController {
    @Resource
    private IResumeService resumeService;

    //HR根据Job的id获取已投递的简历
    @RequestMapping("getResumes")
    @ResponseBody
    public List<Resume> getResumes(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        Integer id = Integer.parseInt(request.getParameter("jobId"));
        return this.resumeService.getResumes(id);
    }

    //根据简历ID查看简历详情
    @RequestMapping("getResumeById")
    @ResponseBody
    public Resume getResumeById(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        Integer id = Integer.parseInt(request.getParameter("id"));
        return this.resumeService.getResumeById(id);
    }

    //获取用户当前简历
    @RequestMapping("getCurResume")
    @ResponseBody
    public Resp getCurResume(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String wechat = request.getParameter("wechat");
        Resp resp;
        if(ObjectUtil.isNullOrEmpty(this.resumeService.getCurResume(wechat))){
            resp = new Resp(true,"用户还未上传简历");
        }else{
            resp = new Resp(true,"可以");
        }
        return resp;
    }

    //添加简历
    @RequestMapping("addResume")
    @ResponseBody
    public Resp addResume(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String wechat = request.getParameter("wechat");
        Integer current = Integer.parseInt(request.getParameter("current"));
        String url = "http://test";
        if(current == 1){
            this.resumeService.deleteCurResume(wechat);
        }
        this.resumeService.addResume(wechat,url,current);
        Resp resp = new Resp(true,"上传简历成功！");
        return resp;
    }

}
