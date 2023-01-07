package com.example.todolist.service;

import com.example.todolist.dto.TaskRequest;
import com.example.todolist.dto.TaskResponse;
import com.example.todolist.entity.Task;
import com.example.todolist.mapper.TaskMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    /**
     * 新建任务
     * @Param taskRequest
     * */
    public void createTask(TaskRequest taskRequest) {
        Task task = new Task();
        task.setTopicId(taskRequest.getTopicId());
        task.setTaskName(taskRequest.getTaskName());
        task.setDefaultTime(taskRequest.getDefaultTime());
        taskMapper.create(task);
    }

    /**
     * 根据话题ID获取该话题所有任务
     * @Param topicId
     * */
    public List<TaskResponse> getAll(Long topicId) {
        return taskMapper.getAllTask(topicId);
    }

    /**
     * 根据任务ID删除任务
     * @Param topicId
     * */
    public void deleteTaskById(Long taskId) {
        taskMapper.deleteTaskById(taskId);
    }
}
