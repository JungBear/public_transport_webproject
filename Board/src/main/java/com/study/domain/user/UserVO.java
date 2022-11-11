package com.study.domain.user;

import java.sql.Date;

import lombok.Data;

@Data
public class UserVO { //데이터 저장소
    private String id;
    private String pwd;
    private String name; 
    private String email; 
    private Date signinDate; // java.sql.Date
    private Date modifiedDate;
 
    
}
