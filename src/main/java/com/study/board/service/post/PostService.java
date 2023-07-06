package com.study.board.service.post;

import com.study.board.domain.post.PostRequest;
import com.study.board.domain.post.PostResponse;
import java.util.List;

public interface PostService {
    Long savePost(PostRequest params);
    PostResponse findByBno(Long bno);
    void update(PostRequest params);
    void deleteByBno(Long bno);
    List<PostResponse> findAll();
    int count();
}
