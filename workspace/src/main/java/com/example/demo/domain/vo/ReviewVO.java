package com.example.demo.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ReviewVO {
	
	private int reviewId;
	private int movieId;
	private int userId;
	private String movieName;
	private String reviewRegisterDate;
	private String reviewUpdateDate;
	private String reviewContent;
	private String reviewRate;
	private int reviewLike;

	

}
