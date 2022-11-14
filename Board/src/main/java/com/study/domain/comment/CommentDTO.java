package com.study.domain.comment;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CommentDTO {
	private int id;
	private int boardId;
	private int boardType;
	private String content;
	private int depth;
	private int groupNo;
	private int order;
	private int writerNo;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	private int delYn;
	private LocalDateTime delDate;
	private int secret;
	
}
