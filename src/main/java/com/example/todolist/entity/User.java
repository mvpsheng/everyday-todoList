package com.example.todolist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * FileName: User
 * author: gxs
 * Date: 2022/12/30  15:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
/**
 * 用户ID（主键）Long
 * 昵称 String
 * 手机号 String
 * 密码 String
 * */

    private Long userId; // uuid
    private String userName;
    private String phoneNumber;
    private String password;
}
