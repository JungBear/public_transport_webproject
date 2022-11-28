package com.study.domain.user;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.study.common.dto.MessageDto;

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
	
	//아이디,비밀번호찾기 페이지
	@GetMapping("/user/findidpwd.do")
	public String findidpwd() {
		return "user/findidpwd";
	}
	
	@PostMapping(value = "/findid")
	@ResponseBody
	public UserRequest findIdAction(@RequestBody final UserRequest params, Model model) {
		UserRequest id = userService.findId(params);
		model.addAttribute("id", id);
		return id;
	}
	
	//비밀번호 찾기 페이지
	@GetMapping("/user/findpwd.do")
	public String findpwd() {
		return "user/findpwd";
	}
	
	@PostMapping(value = "/findpwd")
	@ResponseBody
	public UserRequest findPwdAction(@RequestBody final UserRequest params, Model model) {
		UserRequest pwd = userService.findPwd(params);
		model.addAttribute("id", pwd);
		return pwd;
	}
	
	//마이페이지 
	@GetMapping("/user/UserMyPage.do")
	public String mypage(@SessionAttribute(name = "userInfo", required = false)UserResponse user, Model model) {
		if(user == null) {
        	return "user/needLogin";
        }
		model.addAttribute("userInfo", user);
		return "user/UserMyPage";
	}
	
	// 마이페이지 비번검사
	@GetMapping("/user/UserMyPageChk.do")
	public String checkPwdpage(
			@SessionAttribute(name = "userInfo", required = false)UserResponse user,Model model) {
		if(user == null) {
        	return "user/needLogin";
        }
		model.addAttribute("userInfo", user);
		System.out.println("세선에 저장된 비밀번호 : "+user.getPwd());
		return "user/UserMyPageChk";
	}
	
	@PostMapping("/user/UserMyPageChk")
	@ResponseBody
	public UserRequest checkPwdAction(@RequestBody final UserRequest params,
			@SessionAttribute(name = "userInfo", required = false)UserResponse user,Model model) {
		model.addAttribute("userInfo", user);
		System.out.println("params : "+params);
		return userService.checkPwd(params);
	}
	
    // 회원탈퇴
    @PostMapping("/user/secession.do")
    public String deletePost(@RequestParam final int userNo
    		,@SessionAttribute(name = "userInfo", required = false)UserResponse user, Model model) {
    	if(user == null) {
        	return "user/needLogin";
        }
    	userService.deleteUser(userNo);
    	MessageDto message = new MessageDto("탈퇴가 완료되었습니다.", "/", RequestMethod.GET, null);
    	return showMessageAndRedirect(message,model);
    }
	
    /*  로그아웃 */
    @GetMapping("/logout.do")
    public String logoutMainGET(HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";        
    }
    
    private String showMessageAndRedirect(final MessageDto params, Model model) {
        model.addAttribute("params", params);
        return "common/messageRedirect";
    }
	
}