package com.study.board.domain.file;

import lombok.Builder;
import lombok.Getter;

@Getter
public class FileRequest {

    private Long fno;                // 파일 번호 (PK)
    private Long bno;               // 게시글 번호 (FK)
    private String originalName;    // 원본 파일명
    private String saveName;        // 저장 파일명
    private long size;              // 파일 크기

    @Builder
    public FileRequest(String originalName, String saveName, long size) {
        this.originalName = originalName;
        this.saveName = saveName;
        this.size = size;
    }

    public void setBno(Long bno){
        this.bno = bno;
    }
}