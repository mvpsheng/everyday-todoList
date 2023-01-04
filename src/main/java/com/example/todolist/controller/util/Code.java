package com.example.todolist.controller.util;


public class Code {
    public static final Integer OK = 200; // 表示成功
    public static final Integer SQLERR = 422; // 表示数据库操作失败
    public static final Integer ERR = 404; // 表示错误
    public static final Integer SMSCODEERR = 420; // 表示邮箱验证码错误
    
    // 异常状态码, 50010表示系统异常, 50020表示业务异常, 未知异常状态码: 50050
    public static final Integer SYSTEM_ERR = 401; // 系统异常代码
    // 业务异常状态码
    public static final Integer BUSINESS_ERR = 204; // 业务异常代码
    // 未知异常状态码
    public static final Integer SYSTEM_UNKEOW_ERR = 404;
}
