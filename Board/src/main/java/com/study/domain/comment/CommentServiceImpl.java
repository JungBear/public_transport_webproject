package com.study.domain.comment;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentMapper;

	@Override
	public boolean registerComment(CommentDTO params) {
		int queryResult = 0;

		if (params.getId() == 0) {
			System.out.println("서비스 인서트 실행전");
			queryResult = commentMapper.insertComment(params);
		} else {
			queryResult = commentMapper.updateComment(params);
		}

		return (queryResult == 1) ? true : false;
	}

	@Override
	public boolean deleteComment(int id) {
		int queryResult = 0;

		CommentDTO comment = commentMapper.selectCommentDetail(id);

		if (comment != null && comment.getDelYn() == 0) {
			queryResult = commentMapper.deleteComment(id);
		}

		return (queryResult == 1) ? true : false;
	}

	@Override
	public List<CommentDTO> getCommentList(CommentDTO params) {
		List<CommentDTO> commentList = Collections.emptyList();

		int commentTotalCount = commentMapper.selectCommentTotalCount(params);
		if (commentTotalCount > 0) {
			commentList = commentMapper.selectCommentList(params);
		}

		return commentList;
	}
}
