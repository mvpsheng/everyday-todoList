package com.example.todolist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * FileName: TopicRequst
 * author: gxs
 * Date: 2022/12/31  17:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicResponse {
    private String topicName;
    private boolean completed;
}
