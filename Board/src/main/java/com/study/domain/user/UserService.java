package com.study.domain.user;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;



import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserMapper userMapper;

    /**
     * 회원 정보 저장
     * @param params - 게시글 정보
     * @return 
     * @return Generated PK
     */
    @Transactional
    void saveUser(final UserResponse params) {
        userMapper.userSave(params);
    }

}
