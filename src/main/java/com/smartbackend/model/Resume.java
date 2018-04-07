package com.smartbackend.model;

public class Resume {
    private Integer id;
    private String traineewechat;
    private String url;
    private Integer current;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTraineewechat() {
        return traineewechat;
    }

    public void setTraineewechat(String traineeWechat) {
        this.traineewechat = traineeWechat;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }
}
