package com.example.todolist.dto;

import com.example.todolist.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * FileName: TopicRequst
 * author: gxs
 * Date: 2022/12/31  17:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TopicResponse {
    private Long topicId;
    private String topicName;
    private boolean completed;
    private List<TaskResponse> taskList;
}
