package com.study.domain.goodbad;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodbadMapper {
	int checkGood(GoodbadDTO params);
	
	int checkbad(GoodbadDTO params);
}
