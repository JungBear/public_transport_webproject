package com.study.domain.comment;

import java.util.List;

public interface CommentService {

	public boolean registerComment(CommentDTO params);

	public boolean deleteComment(int id);

	public List<CommentDTO> getCommentList(CommentDTO params);
	
	public CommentDTO getCommentDetail(int id);

}