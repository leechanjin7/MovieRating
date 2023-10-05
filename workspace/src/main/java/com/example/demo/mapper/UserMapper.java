package com.example.demo.mapper;


import com.example.demo.domain.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

	//회원조회(단건)
	public UserVO select(int userId);

	//회원가입
	public void insert(UserVO userVO);

	//회원정보 수정
	public void update(UserVO userVO);
	
	//회원탈퇴
	public void delete(int userId);
	
	
	


}
