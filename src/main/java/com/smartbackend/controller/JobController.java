package com.smartbackend.controller;

import com.smartbackend.model.Job;
import com.smartbackend.service.IJobService;
import com.smartbackend.utils.Resp;
import jdk.nashorn.internal.scripts.JO;
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
@RequestMapping("/job")
public class JobController {
    @Resource
    private IJobService jobService;

    @RequestMapping("getJobById")
    @ResponseBody
    public Job getJobById(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        Integer id = Integer.parseInt(request.getParameter("id"));
        Job job = this.jobService.getJobById(id);
        return job;
    }

    @RequestMapping("getJobs")
    @ResponseBody
    public List<Job> getJobs(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        List<Job> jobs = this.jobService.getJobs();
        return jobs;
    }

    @RequestMapping("addJob")
    @ResponseBody
    public Resp addJob(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        //获取微信小程序get的参数值并打印
        String company = request.getParameter("company");
        String position = request.getParameter("position");
        Integer workDayPerWork =  Integer.parseInt(request.getParameter("workDayPerWeek"));
        Integer minSalary = Integer.parseInt(request.getParameter("minSalary"));
        Integer maxSalary = Integer.parseInt(request.getParameter("maxSalary"));
        String address = request.getParameter("address");
        String education = request.getParameter("education");
        String major = request.getParameter("major");
        Integer recruitNumber = Integer.parseInt(request.getParameter("recruitNumber"));
        Integer monthForWork = Integer.parseInt(request.getParameter("monthForWork"));
        Integer correction = Integer.parseInt(request.getParameter("correction"));
        String endTime = request.getParameter("endTime");
        String description  = request.getParameter("description");
        String hrPosition = request.getParameter("hrPosition");
        String recruiterWechat = request.getParameter("recruiterWechat");
        String picture = request.getParameter("picture");
        this.jobService.addJob(company,position,workDayPerWork,minSalary,maxSalary,address,education,major,recruitNumber,
                monthForWork,correction,endTime,description,hrPosition,recruiterWechat,picture);
        Resp resp = new Resp(true,"发布成功！");
        return resp;
    }
}
