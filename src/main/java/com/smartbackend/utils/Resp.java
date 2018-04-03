package com.smartbackend.utils;

import java.io.Serializable;

public class Resp implements Serializable {
    private boolean success;
    private String msg;

    public Resp(boolean success,String msg){
        this.success = success;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
