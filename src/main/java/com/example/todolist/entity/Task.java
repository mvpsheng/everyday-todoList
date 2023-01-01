package com.example.todolist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * FileName: Task
 * author: gxs
 * Date: 2023/1/1  16:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
/**
 * 任务ID（主键）Long
 * 话题ID（外键）Long
 * 任务名称 String
 * 任务时间 String
 * 任务完成 boolean
 * */
    private Long taskId;
    private Long topicId;
    private String taskName;
    private String defaultTime;
    private boolean finished;
}
