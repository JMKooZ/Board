package com.study.board.domain.comment;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class CommentResponse {

    private Long cno;                       // 댓글 번호 (PK)
    private Long bno;                   // 게시글 번호 (FK)
    private String content;                // 내용
    private String writer;                 // 작성자
    private Boolean deleteYn;              // 삭제 여부
    private LocalDateTime createdDate;     // 생성일시
    private LocalDateTime modifiedDate;    // 최종 수정일시
}
