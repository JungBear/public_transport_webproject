package com.study;

import lombok.Data;

@Data
public class UserRequest {
	//board 
	private Long id;          //PK  
    private String name;	//이름
    private String nickname;	//닉네임
    private String email;	//이메일
    private String pwd;	//비밀번호
    private String pwd_hint;	//비밀번호 힌트 질문
    private String pwd_hint_ans;	//비밀번호 힌트에 대한 답
    private int gender;	//성별
    private int age;	//나이
        
}
