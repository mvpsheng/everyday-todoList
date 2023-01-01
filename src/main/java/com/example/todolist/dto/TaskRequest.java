package com.example.todolist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * FileName: TaskRequest
 * author: gxs
 * Date: 2023/1/1  16:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {
    private Long topicId;
    private String taskName;
    private String defaultTime;
}
