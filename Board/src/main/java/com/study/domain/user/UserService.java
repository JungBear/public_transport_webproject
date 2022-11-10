package com.study.domain.user;

import javax.servlet.http.HttpSession;

public interface UserService {
    // 01_01. 회원 로그인 체크
    public boolean loginCheck(UserVO vo, HttpSession session);
    // 01_02. 회원 로그인 정보
    public UserVO viewMember(UserVO vo);
    // 02. 회원 로그아웃
    public void logout(HttpSession session);
	
}
