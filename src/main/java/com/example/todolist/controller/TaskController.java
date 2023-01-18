package com.example.todolist.controller;

import com.example.todolist.controller.util.Result;
import com.example.todolist.dto.*;
import com.example.todolist.entity.User;
import com.example.todolist.service.TaskService;
import com.example.todolist.service.TopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "Task Interfaces", tags = "Task Interfaces")
@RestController
@RequestMapping("api/task")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    /**
     * 新建任务
     * @Param taskRequest
     * */
    @ApiOperation("add task")
    @PostMapping
    public Result createTask(@RequestBody TaskRequest taskRequest) {
        taskService.createTask(taskRequest);
        List<TaskResponse> allTask = taskService.getAll(taskRequest.getTopicId());
        return new Result(allTask);
    }

    /**
     * 根据话题ID获取该话题所有任务
     * @Param topicId
     * */
    @ApiOperation("get task by topicId")
    @GetMapping("/{topicId}")
    public Result getTasksByTopicId(@PathVariable Long topicId) {
        List<TaskResponse> allTask = taskService.getAll(topicId);
        return new Result(allTask);
    }

    /**
     * 根据任务ID删除任务
     * @Param topicId
     * */
    @ApiOperation("delete task by taskId")
    @DeleteMapping("/deleteById")
    public void deleteTaskById(@RequestBody TaskDeleteRequest taskDeleteRequest) {
        taskService.deleteTaskById(taskDeleteRequest.getTaskId());
    }
}
