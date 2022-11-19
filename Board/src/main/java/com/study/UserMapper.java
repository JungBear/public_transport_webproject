package com.study;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper { //mapper.xml을 불러오는 기능 //왜 인터페이스로 만든 깃이지?
		
	/**
	 * 회원가입 정보 저장
	 * @param User - 회원가입 데이터 저장
	 * void는 return 값이 없는 함수.
     * 오랜만에 보니 뭐지 했네..
	 */
	 void usersave(UserResponse params);
   
	 
	 /**
	  *  
	  */
	
}
