package com.example.demo.mapper;


import com.example.demo.domain.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

	//회원조회(단건)
	public UserDTO select(int userId);

	//회원가입
	public void insert(UserDTO userDTO);

	//회원정보 수정
	public void update(UserDTO userDTO);
	
	//회원탈퇴
	public void delete(int userId);
	
	
	


}
