package com.example.demo.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MovieVO {
	
	private int movieId;
	private String movieName;
	private String movieTime;
	private String movieInfo;
	private String movieType;
	private String movieAct;
	private String movieDic;
	private String movieRelease;

	

}
