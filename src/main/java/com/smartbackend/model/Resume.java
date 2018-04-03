package com.smartbackend.model;

public class Resume {
    private Integer id;
    private String traineeWechat;
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTraineeWechat() {
        return traineeWechat;
    }

    public void setTraineeWechat(String traineeWechat) {
        this.traineeWechat = traineeWechat;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
