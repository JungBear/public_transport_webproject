package com.study;

import java.net.PasswordAuthentication;

import lombok.Data;

@Data
public class UserRequest {
	private Long id;            
    private PasswordAuthentication pwd;     
    
}
