package com.study.board.domain.post;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {
    /**
     * 게시글 저장
     * @param params - 게시글 정보
     */
    void savePost(PostRequest params);

    /**
     * 제시글 상세정보 조회
     * @param bno - pk
     * @return 게시글 상세정보
     */
    PostResponse findByBno(Long bno);

    /**
     * 게시글 수정
     * @param params - 게시글정보
     */
    void update(PostRequest params);

    /**
     * 게시글 삭제
     * @param bno - pk
     */
    void deleteByBno(Long bno);

    /**
     * 게시글 리스트 조회
     * @return 게시글 리스트
     */
    List<PostResponse> findAll();

    /**
     * 게시글 수 카운팅
     * @return 게시글 수
     */
    int count();
}
