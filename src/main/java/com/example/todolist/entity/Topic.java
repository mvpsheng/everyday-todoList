package com.example.todolist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * FileName: Topic
 * author: gxs
 * Date: 2022/12/31  17:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic {
    private Long topicId;
    private Long userId;
    private String topicName;
    private boolean finished;
}
