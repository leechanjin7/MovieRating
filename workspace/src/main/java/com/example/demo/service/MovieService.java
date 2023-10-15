package com.example.demo.service;

import com.example.demo.domain.dto.MovieDTO;
import com.example.demo.domain.paging.Criteria;
import com.example.demo.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieMapper movieMapper;

    //영화 검색(전체 리스트)
    public List<MovieDTO> selectAll(Criteria criteria){

        return movieMapper.selectAll(criteria);
    }

    //영화 목록(페이징처리)
    public List<MovieDTO> moviePaging(Criteria criteria){
        return movieMapper.moviePaging(criteria);
    }

    //영화 총 갯수
    public int getTotal(){
       return movieMapper.getTotal();
    }

}
