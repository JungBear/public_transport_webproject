package com.study.domain.main;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {

	private final MainService MainService;

	@GetMapping(value = "/")
	public String main() {
		return "home";
	}

	@GetMapping(value = "/congestionrate")
	@ResponseBody
	public List<BridgeDTO> getcongestionRate(BridgeDTO bridgeDTO, Model model) {
		System.out.println("컨트롤러 진입");
		List<BridgeDTO> bridgeList = MainService.getcongestionRate(bridgeDTO);
		model.addAttribute("bridgeList", bridgeList);
		System.out.println("bridgeList의 크기 : " + bridgeList.size());
		return bridgeList;
	}

}
