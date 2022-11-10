package com.study.domain.user;

import java.sql.Date;

import lombok.Data;

@Data
public class UserVO { //데이터 저장소
    private String userId;
    private String userPw;
    private String userName; 
    private String userEmail; 
    private Date userRegdate; // java.sql.Date
    private Date userUpdatedate;
 
    
}
