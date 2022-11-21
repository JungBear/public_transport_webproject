package com.study.domain.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
// view -> Controller -> service -> mapper -> xml -> mapper -> service -> controller -> view // 화살표마다 DTO 실행
// view = .html, / .jsp / .php
@Controller
//위에 뜻 = 컨트롤러일 때만.
@RequiredArgsConstructor
public class UserController {
	
	//로그인 페이지 및 회원가입 페이지
	@GetMapping("/user/signinandsignup.do")
	public String signin() {
		return "user/signinAndsignup";
	}
	

	//마이페이지 
	@GetMapping("/user/UserMyPage.do")
	public String mypage() {
		return "user/UserMyPage";
	}
	
	//마이페이지 진입 전 비밀번호 확인하는 페이지
	@GetMapping("/user/UserMyPageChk.do")
	public String mypageconfirm() {
		return "user/UserMyPageChk";
	}
}