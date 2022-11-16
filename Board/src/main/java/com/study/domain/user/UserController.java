package com.study.domain.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class WebController {
	
	@GetMapping("/")
	public String index() {
	    return "user/home";
	}
	
	@GetMapping("/signup")
	public String signup() {
	    return "user/signup";
	}
}
