package com.study.domain.user;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import lombok.Data;

//DTO = response + request
@Data
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
//@Data 안에 getter, setter, ToString이 포함되어 있다.

public class UserResponse implements Serializable{
	//user 
	private int userNo;//PK 
	private String id;//id
    private String userName;//이름
    private String nickname;//닉네임
    private String email;//이메일
    private String pwd;	//비밀번호
    private String pwdHint;//비밀번호 힌트 질문
    private String pwdHintAns;//비밀번호 힌트에 대한 대답
   
    private int gender;//성별
    private LocalDate age;//나이
    private int experience;//경험치
    private int delYn;//삭제여부
    private int Administrator;//관리자 여부
    private int attendanceDate;//출석일
    
    private LocalDateTime signinDate;//로그인 날짜
    private LocalDateTime nowLoginTime;//현재 로그인 시간
    private LocalDateTime recentLoginTime;//직전 로그인 시간
    private LocalDateTime recentLogoutTime;//직전 로그아웃 시간
    private LocalDateTime modifiedDate;//수정 날짜
    private LocalDateTime delDate;//삭제한 날짜
    
}