package com.study.domain.comment;

import java.util.List;

public interface CommentService {

	public boolean registerComment(CommentDTO params);

	public boolean deleteComment(Long id);

	public List<CommentDTO> getCommentList(CommentDTO params);

}