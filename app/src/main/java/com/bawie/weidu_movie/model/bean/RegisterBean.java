package com.bawie.weidu_movie.model.bean;

/**
 * 作者： 姓名
 * 日期： 2019/11/6 11:51
 */
public class RegisterBean {

    /**
     * message : 注册成功
     * status : 0000
     */

    private String message;
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
