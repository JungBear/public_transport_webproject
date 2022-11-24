package com.study.domain.user;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
			session.setAttribute("user", params);
		}
		return "redirect:/";
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