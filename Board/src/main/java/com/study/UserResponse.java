package com.study;

import java.net.PasswordAuthentication;

import lombok.Data;

@Data
public class UserResponse {
	private Long id;            
    private PasswordAuthentication pwd;   
}