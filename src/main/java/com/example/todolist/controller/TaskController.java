package com.example.todolist.controller;

import com.example.todolist.controller.util.Result;
import com.example.todolist.dto.*;
import com.example.todolist.entity.User;
import com.example.todolist.service.TaskService;
import com.example.todolist.service.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

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
    public Result createTask(@RequestBody TaskRequest taskRequest) {
        taskService.create(taskRequest);
        List<TaskResponse> allTask = taskService.getAll(taskRequest.getTopicId());
        return new Result(allTask);
    }

    @GetMapping("/{topicId}")
    public Result getTopic(@PathVariable Long topicId) {
        List<TaskResponse> allTask = taskService.getAll(topicId);
        return new Result(allTask);
    }

    @DeleteMapping("/deleteById")
    public void deleteTaskById(@RequestBody TaskDeleteRequest taskDeleteRequest) {
        taskService.deleteTaskById(taskDeleteRequest.getTaskId());
    }

    @DeleteMapping("/deleteByName")
    public void deleteTaskByName(@RequestBody TaskDeleteRequest taskDeleteRequest) {
        taskService.deleteTaskByName(taskDeleteRequest.getTaskName());
    }
}
