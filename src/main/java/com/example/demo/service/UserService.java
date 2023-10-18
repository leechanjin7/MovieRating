package com.example.demo.service;

import com.example.demo.domain.dto.UserDTO;
import com.example.demo.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

 private final UserMapper userMapper;

    public void join(UserDTO userDTO){
        userMapper.insert(userDTO);
    }

    public void delete(String userid){
        userMapper.delete(userid);
    }

}
