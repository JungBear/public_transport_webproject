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
	
	//회원가입 페이지
	@GetMapping("/user/signup.do")
	public String signup() {
		return "user/signup";
	}
	
	//로그인 페이지
	@GetMapping("/user/signin.do")
	public String signin() {
		return "user/signin";
	}
	
	//아이디,비밀번호찾기 페이지
	@GetMapping("/user/findidpwd.do")
	public String findidpwd() {
		return "user/findidpwd";
	}
	
	//비밀번호 찾기 페이지
	@GetMapping("/user/findpwd.do")
	public String findpwd() {
		return "user/findpwd";
		
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