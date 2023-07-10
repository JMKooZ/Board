package com.study.board.domain.comment;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
// 기본 생성자를 만들어 준다. access 속성을 이용해서 객체 생성을 protected 로 제한한다.
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentRequest {

    private Long cno;           // 댓글 번호 (PK)
    private Long bno;       // 게시글 번호 (FK)
    private String content;    // 내용
    private String writer;     // 작성자
    @Builder
    public CommentRequest(Long bno, String content, String writer) {
        this.bno = bno;
        this.content = content;
        this.writer = writer;
    }
}
