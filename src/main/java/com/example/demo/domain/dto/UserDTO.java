package com.example.demo.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserDTO {
	
	//회원id
	private String userid;
	//회원 pw
	private String userpw;
	//회원 이름
	private String username;
	//회원 email
	private String useremail;
	//회원 생년월일
	private String userbirthday;
	//관리자, 일반회원 구분(관리자 : 1, 일반회원 : 0)
	private int userrole;

}
