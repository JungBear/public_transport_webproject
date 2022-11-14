package com.study.domain.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class WebController {
	
	@GetMapping("/")
	public String index() {
	    return "home";
	}
	
}
