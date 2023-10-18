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
    private UserMapper mapper;


    public UserDTO getUserInfoByEmail(String Userid) {

        return mapper.selectOne(Userid);

    }

    public UserDTO userSearch(String userid) {
        log.info("UserService's user search at userid: " + userid);
        return mapper.selectOne(userid);
    }
}


