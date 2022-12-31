package com.example.todolist.mapper;

import com.example.todolist.entity.Topic;
import com.example.todolist.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * FileName: TopicMapper
 * author: gxs
 * Date: 2022/12/31  17:20
 */
@Mapper
public interface TopicMapper {
    @Insert("INSERT INTO topic(user_id, topicName, finished) VALUES(#{userId}, #{topicName}, #{finished})")
    void create(Topic topic);

    @Update("UPDATE topic SET topicName=#{topicName},finished=#{finished} WHERE topicName =#{topicName}")
    void update(Topic topic);

    @Delete("DELETE FROM topic WHERE topicName =#{topicName}")
    void delete(String topicName);
}
