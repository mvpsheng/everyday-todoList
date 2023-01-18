package com.example.todolist.controller;

import com.example.todolist.dto.AuthenticationResponse;
import com.example.todolist.dto.LoginRequest;
import com.example.todolist.dto.RegisterRequest;
import com.example.todolist.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

/**
 * FileName: UserController
 * author: gxs
 * Date: 2022/12/30  15:25
 */
@Api(value = "Auth Interfaces", tags = "Auth Interfaces")
@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    /**
     * 用户注册
     * @Param registerRequest
     * */
    @ApiOperation("User signup")
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        return new ResponseEntity<>("User Registration Successful",
                OK);
    }

    /**
     * 用户登录
     * @Param loginRequest
     * */
    @ApiOperation("User login")
    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
}
