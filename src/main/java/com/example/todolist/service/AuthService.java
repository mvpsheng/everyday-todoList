package com.example.todolist.service;

import com.example.todolist.dto.AuthenticationResponse;
import com.example.todolist.dto.LoginRequest;
import com.example.todolist.dto.RegisterRequest;
import com.example.todolist.entity.User;
import com.example.todolist.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;
import java.util.UUID;

/**
 * FileName: AuthService
 * author: gxs
 * Date: 2022/12/30  15:34
 */
@Service
@AllArgsConstructor
@Transactional
public class AuthService {

    private final UserMapper userMapper;

    /**
     * 用户注册
     * @Param registerRequest
     * */
    public void signup(RegisterRequest registerRequest) {
        User user = new User();
        user.setUserId(Long.parseLong(UUID.randomUUID().toString()));
        if (registerRequest.getUserName() == null) {
            user.setUserName("用户" + new Random().ints(10));
        } else {
            user.setUserName(registerRequest.getUserName());
        }
        user.setPhoneNumber(registerRequest.getPhoneNumber());
        user.setPassword(registerRequest.getPassword());

        userMapper.insert(user);
    }

    /**
     * 用户登录
     * @Param loginRequest
     * */
    public AuthenticationResponse login(LoginRequest loginRequest) {
        User user = userMapper.getOneByPhoneNumber(loginRequest.getPhoneNumber());
        System.out.println(user);
        if (user == null) {
            return AuthenticationResponse.builder()
                    .loginStatus("登录失败, 不存在的手机号")
                    .build();
        }
        if (user.getPassword().equals(loginRequest.getPassword())) {
            return AuthenticationResponse.builder()
                    .loginStatus("登录成功")
                    .username(user.getUserName())
                    .phoneNumber(user.getPhoneNumber())
                    .userId(user.getUserId())
                    .build();
        } else {
            return AuthenticationResponse.builder()
                    .loginStatus("登录失败， 密码错误")
                    .build();
        }

    }
}
