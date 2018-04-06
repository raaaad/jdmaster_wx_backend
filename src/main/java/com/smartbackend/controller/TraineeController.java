package com.smartbackend.controller;

import com.smartbackend.model.Recruiter;
import com.smartbackend.model.Trainee;
import com.smartbackend.service.ITraineeService;
import com.smartbackend.utils.ObjectUtil;
import com.smartbackend.utils.Resp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/trainee")
public class TraineeController {
    @Resource
    private ITraineeService traineeService;

    @RequestMapping("register")
    @ResponseBody
    public Resp addTrainee(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        //获取微信小程序get的参数值并打印
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String school = request.getParameter("school");
        String telephone = request.getParameter("telephone");
        String major = request.getParameter("major");
        String minor = request.getParameter("minor");
        String education = request.getParameter("education");
        String wechat = request.getParameter("wechat");
        if(!request.getParameter("workdayperweek").isEmpty()){
            Integer workdayperweek = Integer.parseInt(request.getParameter("workdayperweek"));
        }
        Integer workdayperweek = 0;
        String startwork = request.getParameter("startwork");
        String email = request.getParameter("email");
        String graduateTime = request.getParameter("graduateTime");
        this.traineeService.addTrainee(name,gender,school,telephone,major,minor,wechat,workdayperweek,startwork,email,education,graduateTime);
        //返回值给微信小程序
        //Writer out = response.getWriter();
        //out.write("恭喜您，已成功注册！");
        //out.flush();

        Resp resp = new Resp(true,"已成功注册！");
        return resp;
    }

    @RequestMapping("login")
    @ResponseBody
    public Resp traineeLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String wechat = request.getParameter("wechat");
        Trainee trainee = this.traineeService.getTraineeByWechat(wechat);
        if(ObjectUtil.isNullOrEmpty(trainee)){
            Resp resp = new Resp(false,"请注册！");
            return resp;
        }else {
            Resp resp = new Resp(true,"登陆成功！");
            return resp;
        }
    }

    @RequestMapping("getInfo")
    @ResponseBody
    public Trainee getTraineeInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String wechat = request.getParameter("wechat");
        Trainee trainee = this.traineeService.getTraineeByWechat(wechat);
        return trainee;
    }

    @RequestMapping("getAllTrainees")
    @ResponseBody
    public List<Trainee> getAllTrainees(HttpServletRequest request,HttpServletResponse response) throws  ServletException,IOException{
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        List<Trainee> trainees = this.traineeService.getAllTrainees();
        return trainees;
    }

    @RequestMapping("getTraineeById")
    public String getTraineeById(HttpServletRequest request, Model model){
        int traineeId = Integer.parseInt(request.getParameter("id"));
        Trainee trainee = this.traineeService.getTraineeById(traineeId);
        model.addAttribute("trainee",trainee);
        return "Trainee";
    }
}
