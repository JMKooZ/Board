package com.study.board.service.post;

import com.study.board.domain.post.PostMapper;
import com.study.board.domain.post.PostRequest;
import com.study.board.domain.post.PostResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostMapper postMapper;

    @Override
    @Transactional
    public Long savePost(PostRequest params) {
        postMapper.savePost(params);
        return null;
    }

    @Override
    public PostResponse findByBno(Long bno) {
        return postMapper.findByBno(bno);
    }

    @Override
    public void update(PostRequest params) {
        postMapper.update(params);
    }

    @Override
    public void deleteByBno(Long bno) {
        postMapper.deleteByBno(bno);
    }

    @Override
    public List<PostResponse> findAll() {
        return postMapper.findAll();
    }

    @Override
    public int count() {
        return 0;
    }
}
