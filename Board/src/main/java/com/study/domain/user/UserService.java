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
     * 회원 정보 저장
     * @param params - 게시글 정보
     * @return 
     * @return Generated PK
     */
    void saveUser(final UserResponse params) {
        userMapper.userSave(params);
    }
    /**
     * 회원 정보 저장
     * @param params - 아이디 정보
     * @return Generated PK
     */
    public boolean getId(UserRequest params) {
        int n = userMapper.getId(params);
        return n > 0;
    }

    public boolean getNickname(UserRequest params) {
        int n = userMapper.getNickname(params);
        return n > 0;
    }
}
