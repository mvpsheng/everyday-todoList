package com.example.todolist.service;

import com.example.todolist.dto.TopicRequest;
import com.example.todolist.entity.Topic;
import com.example.todolist.mapper.TopicMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * FileName: TopicService
 * author: gxs
 * Date: 2022/12/31  17:18
 */
@Service
@AllArgsConstructor
@Transactional
public class TopicService {

    private final TopicMapper topicMapper;

    public void create(TopicRequest topicRequest, Long userId) {
        Topic topic = new Topic();
        topic.setUserId(userId);
        topic.setTopicName(topicRequest.getTopicName());
        topic.setFinished(false);
        topicMapper.create(topic);
    }

    public List<Topic> getAll(Long userId) {
        return topicMapper.getAll(userId);
    }

    public void updateTopic(TopicRequest topicRequest) {
        Topic topic = new Topic();
        topic.setTopicName(topicRequest.getTopicName());
        topic.setFinished(topicRequest.isCompleted());
        topicMapper.update(topic);
    }
    public String deleteTopicByTopicName(String topicName) {
        topicMapper.delete(topicName);
        return "topic " + topicName + " deleted";
    }
}
