package com.example.demo.service;

import com.example.demo.domain.dto.MovieDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class movieServiceTest {

    @Autowired
    private MovieService service;

    @Test
    public void selectAll(){


        List<MovieDTO> list = service.getAllMovie();
        System.out.println("결과 : " + list);



    }


}
