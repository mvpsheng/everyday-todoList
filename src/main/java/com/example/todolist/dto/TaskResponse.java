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
public class TaskResponse {

    private Long taskId;
    private String taskName;
    private Integer defaultTime;
    private boolean finished;
}
