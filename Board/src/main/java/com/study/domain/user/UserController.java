package com.study.domain.user;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import lombok.RequiredArgsConstructor;
// view -> Controller -> service -> mapper -> xml -> mapper -> service -> controller -> view // 화살표마다 DTO 실행
// view = .html, / .jsp / .php
@Controller
//위에 뜻 = 컨트롤러일 때만.
@RequiredArgsConstructor
public class UserController {
	
	public final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	private final UserService userService;
	
	//회원가입 페이지
	@GetMapping("/user/signup.do")
	public String signup() {
		return "user/signup";
	}
	
	// 아이디중복검사
    @PostMapping("/getId")
    @ResponseBody
    public String getId(UserRequest params) {
        logger.info("UserController getId()");
        boolean b = userService.getId(params);
        if(b) {
            return "no";
        }
        return "ok";
    }
    
	// 닉네임중복검사
    @PostMapping("/getNickname")
    @ResponseBody
    public String getNickname(UserRequest params) {
        logger.info("UserController getId()");
        boolean b = userService.getNickname(params);
        if(b) {
            return "no";
        }
        return "ok";
    }
	
    // 회원가입
    @PostMapping("/user/signup.do")
    @ResponseBody
    public String addMember(UserViewtoControllerDTO params) {
    	UserRequest userrequest = new UserRequest();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateTime = LocalDate.parse(params.getAge(), formatter);
    	BeanUtils.copyProperties(params, userrequest,"age");
    	userrequest.setAge(dateTime);  	
    	logger.info("UserController addMember()");
        boolean b = userService.addMember(userrequest);
        logger.info(params.toString());
        if(b) {
            return "ok";
        }
        System.out.println("b뭐 어쩌라고 "+b);
        return "no";
    }
    
	//로그인 페이지
	@GetMapping("/user/signin.do")
	public String signin() {
		return "user/signin";
	}
	
	@PostMapping("/user/signin.do")
	@ResponseBody
	public String login(UserResponse params, HttpSession session) throws Exception{
		params = userService.login(params);
		if(params != null) {
			session.setAttribute("userInfo", params);
		}
		return "redirect:/";
	}
	
	@GetMapping("/user/UserMyPageChk.do")
	public String checkPwdpage(
			@SessionAttribute(name = "userInfo", required = false)UserResponse user,Model model) {
		if(user == null) {
        	return "user/needLogin";
        }
		System.out.println("세선에 저장된 비밀번호 : "+user.getPwd());
		return "user/UserMyPageChk";
	}
	
	@PostMapping("/user/UserMyPageChk.do")
	public String checkPwd(@SessionAttribute(name = "userInfo", required = false)UserResponse user) {
		return "R";
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
}