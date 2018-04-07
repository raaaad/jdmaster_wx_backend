package com.smartbackend.controller;

import com.smartbackend.service.IHuntingService;
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

@Controller
@RequestMapping("/hunting")
public class HuntingController {
    @Resource
    private IHuntingService huntingService;
    @Resource
    private IResumeService resumeService;

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
        Integer status = Integer.parseInt(request.getParameter("status"));
        Resp resp;
        this.huntingService.changeFollow(wechat,jobId,status);
        if(status==1){
            resp = new Resp(true,"已关注");
        }else{
            resp = new Resp(true,"已取消关注");
        }
        return resp;
    }

    @RequestMapping("sendResume")
    @ResponseBody
    public Resp sendResume(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String wechat = request.getParameter("wechat");
        Integer jobId = Integer.parseInt(request.getParameter("jobId"));
        Integer type = Integer.parseInt(request.getParameter("type"));
        Integer resumeId;
        Resp resp;
        //用户上传默认简历
        if(type==1){
            if(ObjectUtil.isNullOrEmpty(this.resumeService.getCurResume(wechat))){
                resp = new Resp(false,"您暂未上传默认简历!");
                return resp;
            }
            resumeId = this.resumeService.getCurResume(wechat);
        }else{
            //生成url
            //!!!!!!!!
            String url = "http://test?test1";
            this.resumeService.addResume(wechat,url,0);
            resumeId = this.resumeService.getResumeIdByUrl(url);
        }
        this.huntingService.sendResume(wechat,jobId,resumeId);
        resp = new Resp(true,"投递成功");
        return resp;
    }
}
