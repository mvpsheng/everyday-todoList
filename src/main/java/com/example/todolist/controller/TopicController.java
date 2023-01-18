package com.example.todolist.controller;

import com.example.todolist.controller.util.Result;
import com.example.todolist.dto.TopicRequest;
import com.example.todolist.dto.TopicResponse;
import com.example.todolist.entity.Topic;
import com.example.todolist.service.TaskService;
import com.example.todolist.service.TopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "Topic Interfaces", tags = "Topic Interfaces")
@RestController
@RequestMapping("api/topic")
@AllArgsConstructor
public class TopicController {

    private final TopicService topicService;

    /**
     * 新建话题
     * @Param topicRequest
     * */
    @ApiOperation("add topic")
    @PostMapping
    public Result createTopic(@RequestBody TopicRequest topicRequest) {
        topicService.createTopic(topicRequest, topicRequest.getUserId());
        List<TopicResponse> allTopic = topicService.getAll(topicRequest.getUserId());
        return new Result(allTopic);
    }

    /**
     * 根据用户ID获取该用户所有话题（同时获取每一个话题的所有任务）
     * @Param userId
     * */
    @ApiOperation("get topic by userId")
    @GetMapping("/{userId}")
    public Result getTopicByUserId(@PathVariable Long userId) {
        List<TopicResponse> allTopic = topicService.getAll(userId);
        return new Result(allTopic);
    }

    /**
     * 更新话题
     * @Param topicRequest
     * */
    @ApiOperation("update topic")
    @PutMapping
    public Result updateTopic(@RequestBody TopicRequest topicRequest) {
        topicService.updateTopic(topicRequest);
        List<TopicResponse> allTopic = topicService.getAll(topicRequest.getUserId());
        return new Result(allTopic);
    }

    /**
     * 根据话题Id删除话题
     * @Param topicId
     * */
    @ApiOperation("delete topic by topicId")
    @DeleteMapping("deleteTopicByTopicId")
    public void deleteTopicByTopicName(@RequestBody TopicResponse topicResponse) {
        topicService.deleteTopicByTopicId(topicResponse.getTopicId());
    }
}
