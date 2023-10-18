package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RegisterMailTest {

    @Autowired
    private RegisterMail registerMail;

    @Test
    public void sendSimpleMessageTest() throws Exception {
        String code = registerMail.sendSimpleMessage("dutlsghkd@naver.com");
        log.info("============================");
        log.info(code);
        log.info("============================");
    }


}
