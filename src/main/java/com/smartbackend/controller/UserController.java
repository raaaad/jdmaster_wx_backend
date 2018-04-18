package com.smartbackend.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.kevinsawicki.http.HttpRequest;
import com.smartbackend.model.Trainee;
import com.smartbackend.model.User;
import com.smartbackend.service.IRecruiterService;
import com.smartbackend.service.ITraineeService;
import com.smartbackend.service.IUserService;
import com.smartbackend.utils.ObjectUtil;
import com.smartbackend.utils.Resp;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;
    @Resource
    private IRecruiterService recruiterService;
    @Resource
    private ITraineeService traineeService;

    @RequestMapping("getUserById")
    public String getUser(HttpServletRequest request, org.springframework.ui.Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        model.addAttribute("user",user);
        return "User";
    }

    @RequestMapping("login")
    @ResponseBody
    public Resp adminRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String wechat = request.getParameter("wechat");
        String nickname = request.getParameter("nickname");
        User user = this.userService.getUserByWechat(wechat);
        Resp resp;
        if(ObjectUtil.isNullOrEmpty(user)){
            this.userService.addUser(wechat,nickname);
             resp = new Resp(true,"注册成功！");
            return resp;
        }else {
            resp = new Resp(true,"已注册过！");
            return resp;
        }
    }

    @RequestMapping("identity")
    @ResponseBody
    public Resp identity(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String wechat = request.getParameter("wechat");
        Resp resp;
        if(!ObjectUtil.isNullOrEmpty(this.userService.getUserByWechat(wechat))){
            resp = new Resp(true,"admin");
        }else if(!ObjectUtil.isNullOrEmpty(this.recruiterService.getRecruiterByWechat(wechat))){
                resp = new Resp(true,"recruiter");
        }else if(!ObjectUtil.isNullOrEmpty(this.traineeService.getTraineeByWechat(wechat))){
            resp = new Resp(true,"trainee");
        }else{
            resp = new Resp(true,"暂未注册！");
        }
        return resp;
    }

    @RequestMapping("getOpenId")
    @ResponseBody
    public String getOpenId(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String code = request.getParameter("code");
        //String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";

        //请求参数
        Map<String, String> map = new HashMap<>();

        map.put("appid", "wx3613a079e6a03343");
        map.put("secret","40c3ba8335256d20fe77213c16b5b859");
        map.put("js_code", code);
        map.put("grant_type", "authorization_code");
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        HttpRequest httpRequest = HttpRequest.get(url, map, Boolean.TRUE);
        String result = httpRequest.body();
        System.out.println(result);
        //JSONObject jsonObject = httpRequest(url,"GET",null);
//        String openid;
//        if(null != jsonObject){
//            openid=jsonObject.getString("openid");
//            return new Resp(true,openid);
//        }else{
//            return new Resp(false,"请求失败！");
//        }
        return result;
    }
}
