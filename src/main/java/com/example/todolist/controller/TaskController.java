package com.example.todolist.controller;

import com.example.todolist.dto.TaskRequest;
import com.example.todolist.dto.TopicRequest;
import com.example.todolist.entity.User;
import com.example.todolist.service.TaskService;
import com.example.todolist.service.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName: TaskController
 * author: gxs
 * Date: 2023/1/1  16:20
 */
@RestController
@RequestMapping("api/task")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Void> createTask(@RequestBody TaskRequest taskRequest) {
        taskService.create(taskRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
