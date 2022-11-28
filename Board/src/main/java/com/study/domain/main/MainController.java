package com.study.domain.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.study.domain.post.PostResponse;
import com.study.domain.user.UserResponse;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {

	private final MainService MainService;

	@GetMapping(value = "/")
	public String main(@SessionAttribute(name = "userInfo", required = false)UserResponse user,Model model) {
		List<PostResponse> freePosts = MainService.summaryFreeList();
		List<PostResponse> infoPosts = MainService.summaryInfoList();
        model.addAttribute("freePosts", freePosts);
        model.addAttribute("infoPosts", infoPosts);
        model.addAttribute("userInfo", user);
		
		return "home";
	}

	@GetMapping(value = "/congestionrate")
	@ResponseBody
	public List<BridgeDTO> getcongestionRate(BridgeDTO bridgeDTO, Model model) {
		System.out.println("컨트롤러 진입");
		List<BridgeDTO> bridgeList = MainService.getcongestionRate(bridgeDTO);
		model.addAttribute("bridgeList", bridgeList);
		System.out.println("bridgeList값 : "+bridgeList);
		System.out.println("bridgeList의 크기 : " + bridgeList.size());
		return bridgeList;
	}

}
