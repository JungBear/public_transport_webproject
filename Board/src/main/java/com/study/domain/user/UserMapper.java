package com.study.domain.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
	 
	 /**
	  * 아이디 중복 확인
	  * @param User - 입력한 아이디 
	  */
	 int getId(UserRequest params);
	 
	 /**
	  * 닉네임 중복 확인
	  * @param User - 입력한 닉네임 
	  */
	 int getNickname(UserRequest params);
	 
	 /**
	  * 회원가입
	  * @param User - 사용자가 입력한 정보 
	  */
	 int addMember(UserRequest params);
	 
	  /**
	     * 로그인
	     * @param UserRequest
	     * @return UserResponse(유저의 모든 정보)
	     */
	 UserResponse login(UserResponse params) throws Exception;
	 
	 
	 //전체조회
	 @Select("SELECT * FROM user")
	 public List<UserRequest> selectAll();

	 //일부조회
	 @Select("SELECT * FROM user WHERE like '%'||#{id}||'%'")
	 public List<UserRequest> selectOne(@Param("id") String id);
	 
	 
	 
	 
	 
	 
}
