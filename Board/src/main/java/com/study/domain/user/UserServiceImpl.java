package com.study.domain.user;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service // 현재 클래스를 스프링에서 관리하는 service bean으로 등록
public class UserServiceImpl implements UserService {
    
	@Inject
    UserDAO userDao;
    
    // 01_01. 회원 로그인체크
    @Override
    public boolean loginCheck(UserVO vo, HttpSession session) {
        boolean result = userDao.loginCheck(vo);
        if (result) { // true일 경우 세션에 등록
            UserVO vo2 = viewMember(vo);
            // 세션 변수 등록
            session.setAttribute("userId", vo2.getId());
            session.setAttribute("userName", vo2.getName());
        } 
        return result;
    }
    // 01_02. 회원 로그인 정보
    @Override
    public UserVO viewMember(UserVO vo) {
        return userDao.viewMember(vo);
    }
    // 02. 회원 로그아웃
    @Override
    public void logout(HttpSession session) {
        // 세션 변수 개별 삭제
        // session.removeAttribute("userId");
        // 세션 정보를 초기화 시킴
        session.invalidate();
    }
}