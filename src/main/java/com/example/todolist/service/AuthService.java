package com.example.todolist.service;

import com.example.todolist.dto.AuthenticationResponse;
import com.example.todolist.dto.LoginRequest;
import com.example.todolist.dto.RegisterRequest;
import com.example.todolist.entity.User;
import com.example.todolist.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public void signup(RegisterRequest registerRequest) {
        User user = new User();
        user.setUserName(registerRequest.getUserName());
        user.setPhoneNumber(registerRequest.getPhoneNumber());
        user.setPassword(registerRequest.getPassword());

        userMapper.insert(user);
    }

    public AuthenticationResponse login(LoginRequest loginRequest) {
        User user = userMapper.getOneByPhoneNumber(loginRequest.getPhoneNumber());
        if (user == null) {
            return AuthenticationResponse.builder()
                    .loginStatus("登录失败, 不存在的手机号")
                    .build();
        }
        if (user.getPassword().equals(loginRequest.getPassword())) {
            return AuthenticationResponse.builder()
                    .username(user.getUserName())
                    .userId(user.getUserId())
                    .build();
        } else {
            return AuthenticationResponse.builder()
                    .loginStatus("登录失败， 密码错误")
                    .build();
        }

    }
}
