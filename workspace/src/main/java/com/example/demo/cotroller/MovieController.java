package com.example.demo.cotroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class MovieController {

    @GetMapping("/main")
    public String GETMainPage() {

        log.info("메인 페이지 진입");

        return "/main";
    }


}
