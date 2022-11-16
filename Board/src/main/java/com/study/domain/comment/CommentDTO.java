package com.study.domain.comment;



import java.sql.Date;

import lombok.Data;




@Data
public class CommentDTO {
	
	
	private int id;
	private int boardId;
	private int boardType;
	private String content;
	private int cdepth;
	private int groupNo;
	private int corder;
	private int writerNo;
	private Date createdDate;
	private Date modifiedDate;
	private int delYn;
	private Date delDate;
	private int secret;
	
}
