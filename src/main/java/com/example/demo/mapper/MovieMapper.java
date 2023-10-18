package com.example.demo.mapper;


import com.example.demo.domain.dto.MovieDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MovieMapper {
	
	//영화 검색(단건)
	public MovieDTO select(int movieId);

	//영화 검색(전체 리스트)
	public List<MovieDTO> selectAll();

	//영화 추가
	public void insert(MovieDTO MovieDTO);
	
	//영화 수정
	public void update(MovieDTO MovieDTO);
	
	//영화 삭제
	public void delete(int movieId);

}
