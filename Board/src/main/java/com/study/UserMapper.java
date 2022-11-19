package com.study;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper { //mapper.xml을 불러오는 기능 //왜 인터페이스로 만든 깃이지?
	
	/**
     * 회원가입
     * @param User - 회원가입 데이터 저장
     */
     UserResponse usersave(int user);
   
	
}
