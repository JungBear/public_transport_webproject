package com.study.domain.post;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.common.dto.SearchDto;

@Mapper
public interface PostMapper {

    /**
     * 게시글 저장
     * @param params - 게시글 정보
     */
    void save(PostRequest params);

    /**
     * 모든 게시글 상세정보 조회
     * @param id - PK
     * @return 게시글 상세정보
     */
    PostResponse findById(Long id);
    
    /**
     * 정보 게시글 상세정보 조회
     * @param id - PK
     * @return 게시글 상세정보
     */
    PostResponse findByInfoTypeId(Long id);
    
    /**
     * 자유 게시글 상세정보 조회
     * @param id - PK
     * @return 게시글 상세정보
     */
    PostResponse findByFreeTypeId(Long id);
    
    /**
     * 게시글 수정
     * @param params - 게시글 정보
     */
    void update(PostRequest params);

    /**
     * 게시글 삭제
     * @param id - PK
     */
    void deleteById(Long id);

    /**
     * 모든 게시글 리스트 조회
     * @return 게시글 리스트
     */
    List<PostResponse> findAllPost(SearchDto params);
    
    /**
     * 정보 게시글 리스트 조회
     * @return 게시글 리스트
     */
    List<PostResponse> findInfoPost(SearchDto params);
    
    /**
     * 자유 게시글 리스트 조회
     * @return 게시글 리스트
     */
    List<PostResponse> findFreePost(SearchDto params);


    /**
     * 게시글 수 카운팅
     * @return 게시글 수
     */
    int count(SearchDto params);

}