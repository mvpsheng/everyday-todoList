package com.example.todolist.mapper;

import com.example.todolist.dto.TaskResponse;
import com.example.todolist.entity.Task;
import com.example.todolist.entity.Topic;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * FileName: TaskMapper
 * author: gxs
 * Date: 2023/1/1  16:22
 */
@Mapper
public interface TaskMapper {
    @Results({
            @Result(property = "topicId", column = "topic_id")
    })
    @Insert("INSERT INTO task(topic_id, taskName, defaultTime, finished) VALUES(#{topicId}, #{taskName}, #{defaultTime}, #{finished})")
    void create(Task task);
    @Results({
            @Result(property = "topicId", column = "topic_id"),
            @Result(property = "taskId", column = "task_id")
    })
    @Select("Select task_id, taskName, defaultTime, finished from task where topic_Id = #{topicId}")
    List<TaskResponse> getAllTask(Long topicId);

    @Delete("DELETE FROM task WHERE taskName =#{taskName}")
    void delete(String taskName);

    @Results({
            @Result(property = "taskId", column = "task_id")
    })
    @Delete("DELETE FROM task WHERE task_id =#{taskId}")
    void deleteTaskById(Long taskId);

    @Results({
            @Result(property = "taskId", column = "task_id")
    })
    @Delete("DELETE FROM task WHERE taskName =#{taskName}")
    void deleteTaskByName(String taskName);
}
