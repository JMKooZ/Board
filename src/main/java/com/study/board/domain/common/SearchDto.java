package com.study.board.domain.common;

import com.study.board.domain.common.paging.Pagination;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDto {

    private int page;                   // 현재 페이지 수
    private int recordSize;             // 한 페이지에 보여줄 개수
    private int pageSize;               // 화면 하단에 출력할 페이지 넘버링
    private String keyword;             // 검색 키워드
    private String searchType;          // 검색 키워드의 유형
    private Pagination pagination;

    // 기본 생성자로 처음에 초기화 시켜준다.
    public SearchDto() {
        this.page = 1;
        this.recordSize = 10;       // 총 10번까지 버튼 만들거임
        this.pageSize = 10;         // 한페이지에 10개씩 보여줄거임.
    }
    // SQL 에서 LIMIT 구문의 시작부분에 사용되는 메서드.
//    public int getOffset() {
//        return (page - 1) * recordSize;
//    }
}
