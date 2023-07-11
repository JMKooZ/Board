package com.study.board.domain.post;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class PostRequest {
    private Long bno;               // pk
    private String title;           // 제목
    private String content;         // 내용
    private String writer;          // 작성자
    private Boolean noticeYn;       // 공지글 여부
    private List<MultipartFile> files = new ArrayList<>(); // 첨부 파일 list
    private List<Long> removeFileIds = new ArrayList<>();   // 삭제할 첨부파일 fno list
}
