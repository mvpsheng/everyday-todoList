package com.example.todolist.dto;

import lombok.Data;

import java.util.List;

/**
 * FileName: AllTopicData
 * author: gxs
 * Date: 2023/1/9  20:33
 */
@Data
public class AllTopicData {
    private Long topicId;
    private String topicName;
    private boolean completed;
    private Long taskId;
    private String taskName;
    private Integer defaultTime;
    private boolean finished;
}
