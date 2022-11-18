package com.study;

import lombok.Data;

@Data
public class UserRequest {
	//board 
	private Long id;          //PK  
    private String name;
    private String nickname;
    private String email;
    private String pwd;
    private String pwd_hint;
    private String pwd_hint_ans;
    private int gender;
    private int age;
        
}
