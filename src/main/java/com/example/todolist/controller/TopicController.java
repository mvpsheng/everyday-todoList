package com.example.todolist.controller;

import com.example.todolist.controller.util.Result;
import com.example.todolist.dto.TopicRequest;
import com.example.todolist.dto.TopicResponse;
import com.example.todolist.entity.Topic;
import com.example.todolist.service.TaskService;
import com.example.todolist.service.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

/**
 * FileName: TopicController
 * author: gxs
 * Date: 2022/12/31  17:17
 */
@RestController
@RequestMapping("api/topic")
@AllArgsConstructor
public class TopicController {

    private final TopicService topicService;

    @PostMapping
    public Result createTopic(@RequestBody TopicRequest topicRequest) {
        topicService.create(topicRequest, topicRequest.getUserId());
        List<TopicResponse> allTopic = topicService.getAll(topicRequest.getUserId());
        return new Result(allTopic);
    }

    @GetMapping("/{userId}")
    public Result getTopic(@PathVariable Long userId) {
        List<TopicResponse> allTopic = topicService.getAll(userId);
        return new Result(allTopic);
    }

    @PutMapping
    public ResponseEntity<Void> updateTopic(@RequestBody TopicRequest topicRequest) {
        topicService.updateTopic(topicRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("by-user/{topicName}")
    public ResponseEntity<String> deleteTopicByTopicName(String topicName) {
        return status(HttpStatus.OK).body(topicService.deleteTopicByTopicName(topicName));
    }
}
