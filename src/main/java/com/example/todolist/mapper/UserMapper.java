package com.example.todolist.mapper;

import com.example.todolist.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * FileName: UserMapper
 * author: gxs
 * Date: 2022/12/30  15:48
 */
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user")
    List<User> getAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    User getOne(Integer id);

    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "phoneNumber", column = "phone_number")
    })
    @Select("SELECT * FROM user WHERE phone_number = #{phoneNumber}")
    User getOneByPhoneNumber(String phoneNumber);

    @Insert("INSERT INTO user(userName, phone_number, password) VALUES(#{userName}, #{phoneNumber}, #{password})")
    void insert(User user);

    @Update("UPDATE user SET name=#{name},password=#{password},age=#{age} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Integer id);
}
