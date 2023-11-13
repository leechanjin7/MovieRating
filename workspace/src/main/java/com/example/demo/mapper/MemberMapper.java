package com.example.demo.mapper;


import com.example.demo.domain.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	//회원조회(단건)
	public MemberDTO select(int userId);

	//회원가입
	public void insert(MemberDTO memberDTO);

	//회원정보 수정
	public void update(MemberDTO memberDTO);
	
	//회원탈퇴
	public void delete(int userId);
	
	
	


}
