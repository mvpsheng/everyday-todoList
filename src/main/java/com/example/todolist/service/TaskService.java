package com.example.todolist.service;

import com.example.todolist.dto.TaskRequest;
import com.example.todolist.entity.Task;
import com.example.todolist.mapper.TaskMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * FileName: TaskService
 * author: gxs
 * Date: 2023/1/1  16:22
 */
@Service
@AllArgsConstructor
@Transactional
public class TaskService {

    private final TaskMapper taskMapper;

    public void create(TaskRequest taskRequest) {
        Task task = new Task();
        task.setTopicId(taskRequest.getTopicId());
        task.setTaskName(taskRequest.getTaskName());
        task.setDefaultTime(taskRequest.getDefaultTime());
        taskMapper.create(task);
    }
}
