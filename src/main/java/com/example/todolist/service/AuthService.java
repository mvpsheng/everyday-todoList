package com.example.todolist.service;

import com.example.todolist.dto.RegisterRequest;
import com.example.todolist.entity.User;
import com.example.todolist.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserMapper userMapper;
    public void signup(RegisterRequest registerRequest) {
        User user = new User();
        user.setUserName(registerRequest.getUserName());
        user.setPhoneNumber(registerRequest.getPhoneNumber());
        user.setPassword(registerRequest.getPassword());

        userMapper.insert(user);
    }
}
