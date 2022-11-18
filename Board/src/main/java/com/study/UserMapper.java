package com.study;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper { //mapper.xml을 불러오는 기능 //왜 인터페이스로 만든 깃이지?
	
	/**
     * 게시글 저장
     * @param params - 게시글 정보
     */
    void id(UserRequest params);

    /**
     * 게시글 상세정보 조회
     * @param id - PK
     * @return 게시글 상세정보
     */
    UserResponse findById(Long id);
    
    /**
     * 게시글 수정
     * @param params - 게시글 정보
     */
    void update(UserRequest params);

    /**
     * 게시글 삭제
     * @param id - PK
     */
    void deleteById(Long id);

    /**
     * 게시글 리스트 조회
     * @return 게시글 리스트
     */
    List<UserResponse> findAll();

    /**
     * 게시글 수 카운팅
     * @return 게시글 수
     */
    int count();
	
}
