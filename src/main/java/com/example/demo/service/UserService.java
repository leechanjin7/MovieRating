package com.example.demo.service;

import com.example.demo.domain.dto.UserDTO;
import com.example.demo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserMapper usermapper;

    //회원가입
    public void userJoin(UserDTO userDTO){
        usermapper.userJoin(userDTO);
    }

    public UserDTO getUserInfoByEmail(String userId) {

        return usermapper.selectOne(userId);

    }

    public UserDTO userSearch(String userId) {
        log.info("UserService's user search at userid: " + userId);
        return usermapper.selectOne(userId);
    }
}