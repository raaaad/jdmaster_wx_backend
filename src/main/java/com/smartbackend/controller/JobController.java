package com.smartbackend.controller;

import com.smartbackend.model.Job;
import com.smartbackend.service.IJobService;
import com.smartbackend.utils.Constants;
import com.smartbackend.utils.Resp;
import jdk.nashorn.internal.scripts.JO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
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
        return this.jobService.getJobById(id);
    }

    //学生获取所有工作列表
    @RequestMapping("getJobs")
    @ResponseBody
    public List<Job> getJobs(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        return this.jobService.getJobs();

    }

    //学生根据自己的浏览、关注或投递状态获取工作列表
    @RequestMapping("getJobsByStatus")
    @ResponseBody
    public List<Job> getJobsByStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String status = request.getParameter("status");
        String wechat = request.getParameter("wechat");
        return this.jobService.getJobsByStatus(status,wechat);
    }

    //HR获取自己发布的工作列表
    @RequestMapping("getMyJobs")
    @ResponseBody
    public List<Job>getMyJobs(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String wechat = request.getParameter("wechat");
        return this.jobService.getMyJobs(wechat);
    }

    //HR根据JD状态获取自己发布的工作列表
    @RequestMapping("getMyJobByStatus")
    @ResponseBody
    public List<Job>getMyJobByStatus(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String wechat = request.getParameter("wechat");
        Integer status = Integer.parseInt(request.getParameter("status"));
        return this.jobService.getMyJobByStatus(wechat,status);
    }

    //HR更改发布的工作的状态
    @RequestMapping("changeJobStatus")
    public void changeJobStatus(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer status = Integer.parseInt(request.getParameter("status"));
        this.jobService.changeJobStatus(id,status);
        //返回值给微信小程序
        Writer out = response.getWriter();
        out.write("已改变JD状态！");
        out.flush();
    }


    @RequestMapping(value="/addJob",method= RequestMethod.POST)
    @ResponseBody
    public Resp addJob(MultipartFile file,HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String path = request.getSession().getServletContext().getRealPath("images");
        String fileName = file.getOriginalFilename();
        File dir = new File(path,fileName);
        if(!dir.exists()){
            dir.mkdirs();
        }
        String url = Constants.PIC_PATH +fileName;

        //MultipartFile自带的解析方法
        file.transferTo(dir);
        System.out.println("path>>"+ path);

        //获取微信小程序get的参数值并打印
        String company = request.getParameter("company");
        String position = request.getParameter("position");
        Integer workdayperweek;
        if(!request.getParameter("workdayperweek").isEmpty()){
            workdayperweek = Integer.parseInt(request.getParameter("workdayperweek"));
        }else{
            workdayperweek = 0;
        }
        Integer minSalary = Integer.parseInt(request.getParameter("minSalary"));
        Integer maxSalary = Integer.parseInt(request.getParameter("maxSalary"));
        String address = request.getParameter("address");
        String education = request.getParameter("education");
        String major = request.getParameter("major");
        Integer recruitNumber;
        if(!request.getParameter("recruitNumber").isEmpty()){
            recruitNumber = Integer.parseInt(request.getParameter("recruitNumber"));
        }else{
            recruitNumber = 0;
        }
        Integer monthForWork;
        if(!request.getParameter("monthForWork").isEmpty()){
            monthForWork = Integer.parseInt(request.getParameter("monthForWork"));
        }else{
            monthForWork = 0;
        }
        Integer correction = Integer.parseInt(request.getParameter("correction"));
        String endTime = request.getParameter("endTime");
        String description  = request.getParameter("description");
        String hrPosition = request.getParameter("hrPosition");
        String recruiterWechat = request.getParameter("recruiterWechat");
        Integer status = Integer.parseInt(request.getParameter("status"));
        this.jobService.addJob(company,position,workdayperweek,minSalary,maxSalary,address,education,major,recruitNumber,
                monthForWork,correction,endTime,description,hrPosition,recruiterWechat,url,status);
        Resp resp = new Resp(true,"发布成功！");
        return resp;
    }

}
