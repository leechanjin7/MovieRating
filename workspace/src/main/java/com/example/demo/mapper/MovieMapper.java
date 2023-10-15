package com.example.demo.mapper;


import com.example.demo.domain.dto.MovieDTO;
import com.example.demo.domain.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MovieMapper {
	
	//영화 검색(단건)
	public MovieDTO select(int movieId);

	//영화 검색(전체 리스트)
	public List<MovieDTO> selectAll(Criteria criteria);

	//영화 목록(페이징처리)
	public List<MovieDTO> moviePaging(Criteria criteria);

	//영화총갯수
	public int getTotal();

	//영화목록 평점순 조회
	public List<MovieDTO> movieRatingSelect(Criteria criteria);

	//영화 추가
	public void insert(MovieDTO movieDTO);
	
	//영화 수정
	public void update(MovieDTO movieDTO);
	
	//영화 삭제
	public void delete(int movieId);

}
