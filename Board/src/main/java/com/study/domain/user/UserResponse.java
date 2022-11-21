package com.study.domain.user;

import java.time.LocalDateTime;

import lombok.Data;
//DTO = response + request
@Data
public class UserResponse {
	//user 
	private Long id;//PK  
    private String name;//이름
    private String nickname;//닉네임
    private String email;//이메일
    private String pwd;	//비밀번호
    private String pwd_hint;//비밀번호 힌트 질문
    private String pwd_hint_ans;//비밀번호 힌트에 대한 대답
   
    private int gender;//성별
    private int age;//나이
    private int exp;//경험치
    private int del_yn;//삭제여부
    private int Administrator;//관리자 여부
    private int attendance_date;//출석일
    
    private LocalDateTime signin_date;//로그인 날짜
    private LocalDateTime now_login_time;//현재 로그인 시간
    private LocalDateTime recent_login_time;//직전 로그인 시간
    private LocalDateTime recent_logout_time;//직전 로그아웃 시간
    private LocalDateTime modified_date;//수정 날짜
    private LocalDateTime del_date;//삭제한 날짜
    
}