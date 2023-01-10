package com.example.todolist.service;

import com.example.todolist.dto.AllTopicData;
import com.example.todolist.dto.TaskResponse;
import com.example.todolist.dto.TopicRequest;
import com.example.todolist.dto.TopicResponse;
import com.example.todolist.entity.Topic;
import com.example.todolist.mapper.TaskMapper;
import com.example.todolist.mapper.TopicMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    /**
     * 新建话题
     * @Param topicRequest, userId
     * */
    public void createTopic(TopicRequest topicRequest, Long userId) {
        Topic topic = new Topic();
        topic.setUserId(userId);
        topic.setTopicName(topicRequest.getTopicName());
        topic.setFinished(false);
        topicMapper.create(topic);
    }

    /**
     * 根据用户ID获取该用户所有话题（同时获取每一个话题的所有任务）
     * @Param userId
     * */
    public List<TopicResponse> getAll(Long userId) {
//        List<TopicResponse> responseList = new ArrayList<>();
//        List<Topic> allTopic = topicMapper.getAll(userId);
//        for (int i = 0; i < allTopic.size(); i++) {
//            responseList.add(i,new TopicResponse()
//                            .builder()
//                    .topicId(allTopic.get(i).getTopicId())
//                    .topicName(allTopic.get(i).getTopicName())
//                    .taskList(taskMapper.getAllTask(allTopic.get(i).getTopicId()))
//                    .build()
//            );
//        }
        List<TopicResponse> responseList = new ArrayList<>();

        List<AllTopicData> allTopicDataList = topicMapper.getAllTopic(userId);
        int currentTopicId = -1;
        int topicListIndex = 0;
        for (AllTopicData allTopicData : allTopicDataList) {
            if (allTopicData.getTopicId() != currentTopicId) { // 如果id 和 i相同，说明是这是当前话题，只需要加载一遍topic，之后的就加载其任务
                responseList.add(new TopicResponse()
                        .builder()
                        .topicId(allTopicData.getTopicId())
                        .topicName(allTopicData.getTopicName())
                        .taskList(Collections.singletonList(new TaskResponse(
                                allTopicData.getTaskId(),
                                allTopicData.getTaskName(),
                                allTopicData.getDefaultTime(),
                                allTopicData.isFinished())))
                        .build());
                topicListIndex++;
                currentTopicId = responseList.get(topicListIndex - 1).getTopicId().intValue();
            } else if (allTopicData.getTopicId() == currentTopicId) {
                List<TaskResponse> taskList = new ArrayList<>(responseList.get(topicListIndex - 1).getTaskList());
                TaskResponse taskResponse1 = new TaskResponse().builder()
                        .taskId(allTopicData.getTaskId())
                        .taskName(allTopicData.getTaskName())
                        .defaultTime(allTopicData.getDefaultTime())
                        .finished(allTopicData.isFinished())
                        .build();
                taskList.add(taskResponse1);
                responseList.get(topicListIndex - 1).setTaskList(taskList);
//                responseList.get(topicListIndex - 1).getTaskList().add(new TaskResponse()
//                                .builder()
//                                        .taskId(allTopicData.getTaskId())
//                                        .taskName(allTopicData.getTaskName())
//                                        .defaultTime(allTopicData.getDefaultTime())
//                                        .finished(allTopicData.isFinished())
//                                .build());
            }
        }
        return responseList;
    }

    /**
     * 更新话题
     * @Param topicRequest
     * */
    public void updateTopic(TopicRequest topicRequest) {
        Topic topic = topicMapper.getTopicById(topicRequest.getTopicId());
        topic.setTopicName(topicRequest.getTopicName());
        topic.setFinished(topicRequest.isCompleted());
        topicMapper.update(topic.getTopicId());
    }

    /**
     * 根据话题Id删除话题
     * @Param topicId
     * */
    public void deleteTopicByTopicId(Long topicId) {
        topicMapper.deleteTopicById(topicId);
    }
}
