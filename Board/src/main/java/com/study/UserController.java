package com.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
//위에 뜻 = 컨트롤러일 때만.
@RequiredArgsConstructor
public class UserController {
	
	//로그인 페이지 및 회원가입 페이지
	@GetMapping("/user/signinandsignup.do")
	public String signin() {
		return "user/signinAndsignup";
	}
	
	@GetMapping("/")
	public String main() {
		return "home";
	}
}