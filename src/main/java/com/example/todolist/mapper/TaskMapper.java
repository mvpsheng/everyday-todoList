package com.example.todolist.mapper;

import com.example.todolist.entity.Task;
import com.example.todolist.entity.Topic;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * FileName: TaskMapper
 * author: gxs
 * Date: 2023/1/1  16:22
 */
@Mapper
public interface TaskMapper {
    @Insert("INSERT INTO task(topic_id, taskName, defaultTime, finished) VALUES(#{topicId}, #{taskName}, #{defaultTime}, #{finished})")
    void create(Task task);


    @Delete("DELETE FROM task WHERE taskName =#{taskName}")
    void delete(String taskName);
}
