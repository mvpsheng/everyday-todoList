package com.example.todolist.service;

import com.example.todolist.dto.TopicRequest;
import com.example.todolist.dto.TopicResponse;
import com.example.todolist.entity.Topic;
import com.example.todolist.mapper.TaskMapper;
import com.example.todolist.mapper.TopicMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    private final TaskMapper taskMapper;

    public void create(TopicRequest topicRequest, Long userId) {
        Topic topic = new Topic();
        topic.setUserId(userId);
        topic.setTopicName(topicRequest.getTopicName());
        topic.setFinished(false);
        topicMapper.create(topic);
    }

    public List<TopicResponse> getAll(Long userId) {
        List<TopicResponse> responseList = new ArrayList<>();
        List<Topic> allTopic = topicMapper.getAll(userId);
        for (int i = 0; i < allTopic.size(); i++) {
            responseList.add(i,new TopicResponse()
                            .builder()
                    .topicId(allTopic.get(i).getTopicId())
                    .topicName(allTopic.get(i).getTopicName())
                    .taskList(taskMapper.getAllTask(allTopic.get(i).getTopicId()))
                    .build()
            );
        }
        return responseList;
    }

    public void updateTopic(TopicRequest topicRequest) {
        Topic topic = new Topic();
        topic.setTopicName(topicRequest.getTopicName());
        topic.setFinished(topicRequest.isCompleted());
        topicMapper.update(topic);
    }

    public void deleteTopicByTopicId(Long topicId) {
        topicMapper.deleteTopicById(topicId);
    }
}
