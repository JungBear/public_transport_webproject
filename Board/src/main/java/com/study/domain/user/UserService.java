package com.study.domain.user;

import javax.transaction.Transactional;

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
    
    public UserResponse login(UserRequest params) {
        return userMapper.login(params);
    }
}
