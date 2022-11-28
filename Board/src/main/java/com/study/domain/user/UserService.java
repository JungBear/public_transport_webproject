package com.study.domain.user;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
	
	
	private final UserMapper userMapper;
    
    /**
     * 아이디체크
     * @param params - 아이디 정보
     * @return  true, false
     */
    public boolean getId(UserRequest params) {
        int n = userMapper.getId(params);
        return n > 0;
    }
    
    /**
     * 닉네임체크
     * @param params - 닉네임 정보
     * @return  true, false
     */
    public boolean getNickname(UserRequest params) {
        int n = userMapper.getNickname(params);
        return n > 0;
    }
    
    /**
     * 회원가입
     * @param params - 사용자가 작성한 정보
     * @return  true, false
     */
    public boolean addMember(UserRequest params) {
        int n = userMapper.addMember(params);
        return n > 0;
    }
    
    /*
     * 로그인
     */
    public UserResponse login(UserResponse params) throws Exception {
        return userMapper.login(params);
    }
    
    public UserRequest findId(UserRequest params) {
    	return userMapper.findId(params);
    }
    
    
   public UserRequest findPwd(UserRequest params) {
	   return userMapper.findPwd(params);
   }
   
   /**
    * 마이페이지 전 비번확인
    * @param params - 비밀번호
    * @return  비밀번호
    */
   UserRequest checkPwd(UserRequest params) {
	   return userMapper.checkPwd(params);
   };
   
   /**
    * 회원탈퇴
    * @param params - 사용자번호
    * @return  사용자번호
    */
   public int deleteUser(final int id) {
	   userMapper.deleteUser(id);
       return id;
   }
   
    public List<UserRequest> getAll(){
    	return userMapper.selectAll();
    }
    
    
    //넘겨받은 id 파라미터로 selectOne 메서드 실행
    public List<UserRequest> getOne(String id){
    	return userMapper.selectOne(id);
    }
    
    
    
}
