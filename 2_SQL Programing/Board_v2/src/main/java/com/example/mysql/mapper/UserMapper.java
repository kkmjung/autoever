package com.example.mysql.mapper;

import com.example.mysql.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll();

    //User findById(@Param("id") Long id);
    User findById(Long id);

    void insert(User user);

    void update(User user);

    void deleteById(Long id);
}
