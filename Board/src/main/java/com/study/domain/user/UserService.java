package com.study.domain.user;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserMapper userMapper;
	/**
	 * 유저 정보 저장
	 * @param params - 유저 정보
	 * @return Generated PK
	 */
	@Transactional
	public int userSave(final UserResponse params) {
		userMapper.userSave(params);
		return params.getUserNo();
	}
}
