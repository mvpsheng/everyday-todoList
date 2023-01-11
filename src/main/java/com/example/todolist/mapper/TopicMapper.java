package com.example.todolist.mapper;

import com.example.todolist.dto.AllTopicData;
import com.example.todolist.entity.Topic;
import com.example.todolist.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * FileName: TopicMapper
 * author: gxs
 * Date: 2022/12/31  17:20
 */
@Mapper
public interface TopicMapper {
    @Insert("INSERT INTO topic(user_id, topicName, finished) VALUES(#{userId}, #{topicName}, #{finished})")
    void create(Topic topic);

    @Results({
            @Result(property = "topicId", column = "topic_id"),
            @Result(property = "userId", column = "user_id")
    })
    @Update("UPDATE topic SET topicName=#{topicName},finished=#{finished} WHERE topic_id =#{topicId}")
    void update(Long topicId);

    @Results({
            @Result(property = "topicId", column = "topic_id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "taskId", column = "task_id")
    })
    @Select("SELECT top.topic_id, top.topicName, top.finished, tas.task_id, tas.taskName, tas.defaultTime, tas.finished from topic top\n" +
            " left join task tas on top.topic_id = tas.topic_id where user_id = #{userID}" +
            " order by top.topic_id;")
    List<AllTopicData> getAllTopic(Long userId);
    @Results({
            @Result(property = "topicId", column = "topic_id"),
            @Result(property = "userId", column = "user_id")
    })
    @Select("Select * from topic where user_Id = #{userId}")
    List<Topic> getAll(Long userId);

    @Results({
            @Result(property = "topicId", column = "topic_id"),
            @Result(property = "userId", column = "user_id")
    })
    @Select("Select * from topic where topic_id = #{topicId}")
    Topic getTopicById(Long topicId);

    @Results({
            @Result(property = "topicId", column = "topic_id")
    })
    @Delete("DELETE FROM topic WHERE topic_id = #{topicId}")
    void deleteTopicById(Long topicId);
}
