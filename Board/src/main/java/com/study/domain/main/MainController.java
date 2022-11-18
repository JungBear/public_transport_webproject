package com.study.domain.main;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<MainDTO> getcongestionRate(@RequestParam("bridge") String bridge, @RequestParam("selectDate")String selectDate, @RequestParam("selHour")String selHour, Model model) {
//		System.out.println("범인은 이안에있다");
		MainDTO MDTO = new MainDTO();
		MDTO.setName(bridge);
//		System.out.println("범인은 바로너!");
		Date d = Date.valueOf(selectDate);
		MDTO.setDate(d);
//		System.out.println(time+":00");
		Time T = Time.valueOf(selHour+":00"); //time
		MDTO.setTime(T);
//		System.out.println("범인은 바로너!");
//		System.out.println("이름세팅 MDTO.getTime :"+MDTO.getTime());
		List<MainDTO>MDTOList = MainService.getcongestionRate(MDTO);
		model.addAttribute("MDTOList", MDTOList);
		System.out.println("MDTOList : "+MDTOList);
		return MDTOList;
	}
	
	
	/* /comments?boardId=xxx/ comments/xx */
//	@GetMapping(value = "/comments")
//	@ResponseBody 
//	public List<CommentDTO> getCommentList(@RequestParam("boardId") int postId,Model model) {
//		System.out.println("getCommentList실행");
//		CommentDTO CDTO = new CommentDTO();
//		CDTO.setBoardId(postId);
//		List<CommentDTO> commentList = commentService.getCommentList(CDTO);
//		System.out.println("받아온 댓글 리스트 commentList : "+commentList);
//		if (CollectionUtils.isEmpty(commentList) == false) {
//			System.out.println(commentList);
//			model.addAttribute("commentList", commentList);
//		}
//
//		return commentList;
//	}
	
//	// /comments - 댓글작성, /comments/{id} - 댓글수정
//	@RequestMapping(value = { "/comments", "/comments/{idx}" }, method = { RequestMethod.POST, RequestMethod.PATCH })
//	public JsonObject registerComment(@PathVariable(value = "id", required = false) Integer id, @RequestBody final CommentDTO params) {
//		System.out.println("registerComment 컨트롤러 인식됨");
//		JsonObject jsonObj = new JsonObject();
//		params.setWriterNo(1);
//		params.setBoardType(0);
//		try {
//			if (id != null) {
//				params.setId(id);
//				
//			}
//			System.out.println("서비스 전");
//			boolean isRegistered = commentService.registerComment(params);
//			jsonObj.addProperty("result", isRegistered);
//
//		} catch (DataAccessException e) {
//			jsonObj.addProperty("message", "데이터베이스 처리 과정에 문제가 발생하였습니다.");
//
//		} catch (Exception e) {
//			jsonObj.addProperty("message", "시스템에 문제가 발생하였습니다.");
//		}
//
//		return jsonObj;
//	}
}
