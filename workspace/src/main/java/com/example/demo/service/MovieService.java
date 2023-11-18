package com.example.demo.service;

import com.example.demo.domain.dto.MovieDTO;
import com.example.demo.domain.dto.Search;
import com.example.demo.domain.paging.Criteria;
import com.example.demo.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class MovieService {
    @Autowired
    private final MovieMapper mapper;

    //전체영화 조회
    public List<MovieDTO> selectAll(Criteria criteria){

        return mapper.selectAll(criteria);
    }

    //영화 목록(페이징처리)
    public List<MovieDTO> moviePaging(Criteria criteria){
        return mapper.moviePaging(criteria);
    }

    //영화 총 갯수
    public int getTotal(Search search){
        return mapper.searchCountAll(search);
    }

    //영화목록조회(검색추가)(평점순)
    public List<MovieDTO> getList(Criteria criteria, Search search){
        return mapper.getList(criteria, search);
    }

    //영화목록조회(검색추가)(가나다순)
    public List<MovieDTO> getList2(Criteria criteria, Search search){
        return mapper.getList2(criteria, search);
    }

    //영화목록조회(검색추가)(신작순)
    public List<MovieDTO> getList3(Criteria criteria, Search search){
        return mapper.getList3(criteria, search);
    }



    //목록페이징(검색추가)
    public List<MovieDTO> getListPaging(Criteria criteria, Search search){
        return mapper.getListPaging(criteria, search);
    }

//    public MovieDTO getMovieById(int movieId){
//        return mapper.select(movieId);
//    }

    public MovieDTO getMovieById(int movieId){
        MovieDTO movie = mapper.select(movieId);
        log.info("ID {}로 영화 검색: {}", movieId, movie);
        return movie;
    }

}