package com.study.board.service.post;

import com.study.board.domain.common.SearchDto;
import com.study.board.domain.common.paging.PagingResponse;
import com.study.board.domain.post.PostRequest;
import com.study.board.domain.post.PostResponse;
import java.util.List;

public interface PostService {
    Long savePost(PostRequest params);
    PostResponse findByBno(Long bno);
    void update(PostRequest params);
    void deleteByBno(Long bno);
    PagingResponse<PostResponse> findAll(SearchDto params);
    int count(SearchDto params);
}
