package com.study.board.domain.comment;

import com.study.board.domain.common.CommentSearchDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {
    /**
     * 댓글 저장
     * @param params - 댓글 정보
     */
    Long saveComment(CommentRequest params);

    /**
     * 댓글 상세정보 조회
     * @param cno - PK
     * @return 댓글 상세정보
     */
    CommentResponse findByCno(Long cno);

    /**
     * 댓글 수정
     * @param params - 댓글 정보
     */
    Long updateComment(CommentRequest params);

    /**
     * 댓글 삭제
     * @param cno - PK
     */
    Long deleteByCno(Long cno);

    /**
     * 댓글 리스트 조회
     * @param params - 게시글 번호 (FK)
     * @return 댓글 리스트
     */
    List<CommentResponse> findAll(CommentSearchDto params);

    /**
     * 댓글 수 카운팅
     * @param params - 게시글 번호 (FK)
     * @return 댓글 수
     */
    int count(CommentSearchDto params);
}
