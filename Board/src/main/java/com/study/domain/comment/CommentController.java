package com.study.domain.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	// /comments - 댓글작성, /comments/{id} - 댓글수정
	@RequestMapping(value = { "/comments", "/comments/{id}" }, method = { RequestMethod.POST, RequestMethod.PATCH })
	public CommentDTO registerComment(@PathVariable(value = "id", required = false) Integer id, @RequestBody final CommentDTO params,Model model) {
		System.out.println("registerComment 컨트롤러 인식됨");
		params.setWriterNo(1);
		try {
			if (id != null) {
				params.setId(id);
				
			}
			System.out.println("서비스 전");
			boolean isRegistered = commentService.registerComment(params);
			model.addAttribute("result", isRegistered);

		} catch (DataAccessException e) {
			model.addAttribute("message", "데이터베이스 처리 과정에 문제가 발생하였습니다.");

		} catch (Exception e) {
			model.addAttribute("message", "시스템에 문제가 발생하였습니다.");
		}
		model.addAttribute("CDTO",params);

		return params;
	}

	/* /comments?boardId=xxx/ comments/xx */
	@GetMapping(value = "/comments")
	public List<CommentDTO> getCommentList(@RequestParam("boardId") int boardId,Model model) {
//		System.out.println("getCommentList실행");
		CommentDTO CDTO = new CommentDTO();
		CDTO.setBoardId(boardId);
		List<CommentDTO> commentList = commentService.getCommentList(CDTO);
//		System.out.println("받아온 댓글 리스트 commentList : "+commentList);
		if (CollectionUtils.isEmpty(commentList) == false) {
//			System.out.println("if문 안쪽 받아온 댓글 리스트 commentList :"+commentList);
			model.addAttribute("commentList", commentList);
		}
//		System.out.println("if문 끝나고 받아온 댓글 리스트 commentList :"+commentList);
		return commentList;
	}

}