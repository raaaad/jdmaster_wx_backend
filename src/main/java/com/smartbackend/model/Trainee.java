package com.smartbackend.model;

import java.util.Date;

public class Trainee {
    private Integer id;
    private String wechat;
    private String name;
    private String gender;
    private String school;
    private String telephone;
    private String mail;
    private String education;
    private String major;
    private String minor;
    private Integer workDayPerWeek;
    private String timeStartWork;
    private String graduateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public Integer getWorkDayPerWeek() {
        return workDayPerWeek;
    }

    public void setWorkDayPerWeek(Integer workDayPerWeek) {
        this.workDayPerWeek = workDayPerWeek;
    }

    public String getTimeStartWork() {
        return timeStartWork;
    }

    public void setTimeStartWork(String timeStartWork) {
        this.timeStartWork = timeStartWork;
    }

    public String getGraduateTime() {
        return graduateTime;
    }

    public void setGraduateTime(String graduateTime) {
        this.graduateTime = graduateTime;
    }
}
