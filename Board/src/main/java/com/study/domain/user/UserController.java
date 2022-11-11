package com.study.domain.user;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //현재 클래스를 스프링에서 관리하는 컨트롤러 bean으로 생성
@RequestMapping("/user/*") //모든 맵핑은 /user/를 상속
public class UserController {
    // 로깅을 위한 변수
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    
    @Inject
    UserService userService;
    
    // 01. 로그인 화면 
//    @RequestMapping("login.do")
    @GetMapping("/user/login.do")
    public String login(){
        return "user/login";    // views/member/login.jsp로 포워드
    }
    
    // 02. 로그인 처리
    @RequestMapping("loginCheck.do")
    public ModelAndView loginCheck(@ModelAttribute UserVO vo, HttpSession session){
        boolean result = userService.loginCheck(vo, session);
        ModelAndView mav = new ModelAndView();
        if (result == true) { // 로그인 성공
            // main.jsp로 이동
            mav.setViewName("home");
            mav.addObject("msg", "success");
        } else {    // 로그인 실패
            // login.jsp로 이동
            mav.setViewName("user/login");
            mav.addObject("msg", "failure");
        }
        return mav;
    }
    
    // 03. 로그아웃 처리
    @RequestMapping("logout.do")
    public ModelAndView logout(HttpSession session){
        userService.logout(session);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/login");
        mav.addObject("msg", "logout");
        return mav;
    }
}