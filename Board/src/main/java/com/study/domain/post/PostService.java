package com.study.domain.post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;

    /**
     * 게시글 저장
     * @param params - 게시글 정보
     * @return Generated PK
     */
    @Transactional
    public Long savePost(final PostRequest params) {
        postMapper.save(params);
        return params.getId();
    }

    /**
     * 게시글 상세정보 조회
     * @param id - PK
     * @return 게시글 상세정보
     */
    public PostResponse findById(final Long id) {
        return postMapper.findById(id);
    }    
    
    /**
     * 정보 게시글 상세정보 조회
     * @param id - PK
     * @return 게시글 상세정보
     */
    public PostResponse findByInfoTypeId(final Long id) {
        return postMapper.findByInfoTypeId(id);
    }
    
    /**
     * 자유 게시글 상세정보 조회
     * @param id - PK
     * @return 게시글 상세정보
     */
    public PostResponse findByFreeTypeId(final Long id) {
        return postMapper.findByFreeTypeId(id);
    }

    /**
     * 게시글 수정
     * @param params - 게시글 정보
     * @return PK
     */
    @Transactional
    public Long updatePost(final PostRequest params) {
        postMapper.update(params);
        return params.getId();
    }

    /**
     * 게시글 삭제
     * @param id - PK
     * @return PK
     */
    public Long deletePost(final Long id) {
        postMapper.deleteById(id);
        return id;
    }

    /**
     * 모든 게시글 리스트 조회
     * @return 게시글 리스트
     */
    public List<PostResponse> findAllPost() {
        return postMapper.findAllPost();
    }
    /**
     * 모든 게시글 리스트 조회
     * @return 게시글 리스트
     */
    List<PostResponse> findInfoPost(){
        return postMapper.findInfoPost();
    }
    
    /**
     * 모든 게시글 리스트 조회
     * @return 게시글 리스트
     */
    List<PostResponse> findFreePost(){
        return postMapper.findFreePost();
    }

}