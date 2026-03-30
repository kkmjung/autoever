package com.example.mysql.service;

import com.example.mysql.mapper.UserMapper;
import com.example.mysql.model.User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

//    public UserService(UserMapper userMapper){
//        this.userMapper = userMapper;
//    }

    public List<User> getAllUsers(){return userMapper.findAll();}
    public User getUserById(Long id) {return userMapper.findById(id);}
    public void createUser(User user) { userMapper.insert(user);}
    public void updateUser(User user) { userMapper.update(user);}
    public void deleteUserById(Long id) {userMapper.deleteById(id);}
}
