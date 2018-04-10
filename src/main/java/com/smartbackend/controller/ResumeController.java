package com.smartbackend.controller;

import com.alibaba.fastjson.JSON;
import com.smartbackend.model.Resume;
import com.smartbackend.service.IResumeService;
import com.smartbackend.utils.Constants;
import com.smartbackend.utils.ObjectUtil;
import com.smartbackend.utils.Resp;
import com.sun.corba.se.impl.orbutil.closure.Constant;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

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
        Resume resume = this.resumeService.getCurResume(wechat);
        if(ObjectUtil.isNullOrEmpty(resume)){
            resp = new Resp(true,"用户暂未上传默认简历！");
        }else{
            resp = new Resp(true,resume.getUrl());
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

    @RequestMapping("/uploadImg")
    @ResponseBody
    public String uploadImg(MultipartFile file,HttpServletRequest request) throws IOException{
        System.out.println("comming!");
        String path = request.getSession().getServletContext().getRealPath("/images");
        System.out.println("path>>"+path);

        String fileName = file.getOriginalFilename();
        System.out.println("fileName>>"+fileName);

        File dir = new File(path, fileName);
        System.out.println("dir.exists()>>"+dir.exists());
        if(!dir.exists()){
            dir.mkdirs();
        }
        System.out.println("dir.exists()>>"+dir.exists());
//      MultipartFile自带的解析方法
        file.transferTo(dir);

        return "ok";
    }


    @RequestMapping(value="/upload",method= RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartFile file, HttpServletRequest request) throws IOException{
        String path = request.getSession().getServletContext().getRealPath("images");
        String fileName = file.getOriginalFilename();
        File dir = new File(path,fileName);
        if(!dir.exists()){
            dir.mkdirs();
        }
        String url = Constants.PIC_PATH +fileName;
        String wechat = request.getParameter("wechat");
        Integer current = Integer.parseInt(request.getParameter("current"));
        this.resumeService.addResume(wechat,url,current);
        //MultipartFile自带的解析方法
        file.transferTo(dir);
        System.out.println("path>>"+ path);
        return "ok!";
    }
}
