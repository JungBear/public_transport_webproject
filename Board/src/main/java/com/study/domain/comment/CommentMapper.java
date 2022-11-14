package com.study.domain.comment;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {
	
	/*
	 * @param = 댓글정보
	 */
	public int insertComment(CommentDTO params);

	/*
	 * @param = 댓글번호
	 */
	public CommentDTO selectCommentDetail(Long id);

	public int updateComment(CommentDTO params);

	public int deleteComment(Long id);

	public List<CommentDTO> selectCommentList(CommentDTO params);

	public int selectCommentTotalCount(CommentDTO params);
}
