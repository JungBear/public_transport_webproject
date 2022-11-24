package com.study.domain.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper { //mapper.xml을 불러오는 기능 //왜 인터페이스로 만든 깃이지?
		
	/**
	 * 회원가입 정보 저장
	 * @param User - 회원가입 데이터 저장
	 * void는 return 값이 없는 함수.
     * 오랜만에 보니 뭐지 했네..
	 */
	 void userSave(UserResponse params);
   
	 
	 /**
	  * 로그인 되는지 확인
	  * @param User - 저장된 아이디, 비밀번호 확인  
	  */
	 void userSignIn(UserResponse params);
}
