package com.example.demo.service;

import com.example.demo.domain.dto.MovieDTO;
import com.example.demo.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

 @Autowired
 MovieMapper mapper;

    public List<MovieDTO> getAllMovie() {
        return mapper.selectAll();
    }
}
