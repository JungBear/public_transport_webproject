package com.study.domain.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	/*@GetMapping("/mypage")
	/auth/를 빼고 작성해준다 왜냐면 
	로그인 시에만 들어올 수 있게 해 주기 위해서 이다
	@GetMapping("/mypage")
	/auth/를 빼고 작성해준다 왜냐면 
	로그인 시에만 들어올 수 있게 해 주기 위해서 이다
	@AuthenticationPrincipal principaldetail principaldetail
	로그인을 성공했다면 
	여기에서 로그인한 사용자 정보를 꺼내 쓸 수 있다
	역시 스프링이 자체적으로 제공하는 기능이다 
	편리하고 보안성 있다
	그리고 model에 uservo를 통으로 넘겨주고 
	html에서 사용해준다
	
	@GetMapping("/user/UserMyPage.do")
	public String mypage(@AuthenticationPrincipal principaldetail principaldetail,Model model) {
		model.addAttribute("userresponse", principaldetail.getUserresponse());
		return "user/UserMyPage";
	}
	*/
	
	@GetMapping("/user/UserMyPage.do")
	public String mypage(){
		return "user/UserMyPage";
	}
	
	
	//마이페이지 진입 전 비밀번호 확인하는 페이지
	@GetMapping("/user/UserMyPageChk.do")
	public String mypageconfirm() {
		return "user/UserMyPageChk";
	}
	
	
	
}