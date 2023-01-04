package com.example.todolist.controller.util;

public class Result {
    private Integer code = Code.OK;
    private Object data;
    private String msg;
    
    public Result(Object data, String msg) {
        this.data = data;
        this.msg = msg;
    }
    
    public Result(Object data){
        this.data = data;
    }
    
    
    public Result(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }
    
    public Result(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
    
    public Integer getCode() {
        return code;
    }
    
    public void setCode(Integer code) {
        this.code = code;
    }
    
    public Object getData() {
        return data;
    }
    
    public void setData(Object data) {
        this.data = data;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
