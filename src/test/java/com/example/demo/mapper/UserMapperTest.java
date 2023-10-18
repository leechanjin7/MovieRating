package com.example.demo.mapper;

import com.example.demo.domain.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
@Slf4j
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void insertTest(){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserid("user2");
        userDTO.setUserpw("1234");
        userDTO.setUsername("홍길동");
        userDTO.setUserrole(1);
        userDTO.setUserbirthday("2000.01.01");
        userDTO.setUseremail("test@test.com");

        userMapper.insert(userDTO);



    }
}
