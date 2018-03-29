package com.smartbackend.controller;

import com.smartbackend.model.Trainee;
import com.smartbackend.service.ITraineeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/trainee")
public class TraineeController {
    @Resource
    private ITraineeService traineeService;

    @RequestMapping("getAllTrainees")
    public String getAllTrainees(HttpServletRequest request, org.springframework.ui.Model model){
        List<Trainee> trainees = this.traineeService.getAllTrainees();
        model.addAttribute("trainees",trainees);
        return "Trainee";
    }

    @RequestMapping("getTraineeById")
    public String getTraineeById(HttpServletRequest request, Model model){
        int traineeId = Integer.parseInt(request.getParameter("id"));
        Trainee trainee = this.traineeService.getTraineeById(traineeId);
        model.addAttribute("trainee",trainee);
        return "Trainee";
    }
}
