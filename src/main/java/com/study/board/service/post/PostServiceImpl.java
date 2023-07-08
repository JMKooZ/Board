package com.study.board.service.post;

import com.study.board.domain.common.SearchDto;
import com.study.board.domain.common.paging.Pagination;
import com.study.board.domain.common.paging.PagingResponse;
import com.study.board.domain.post.PostMapper;
import com.study.board.domain.post.PostRequest;
import com.study.board.domain.post.PostResponse;
import java.util.Collections;
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
    public PagingResponse<PostResponse> findAll(SearchDto params) {
        int count = postMapper.count(params);
        // 데이터가 없으면 빈 컬렉션을 반환 한다.
        if (count < 1){
            return new PagingResponse<>(Collections.emptyList(), null);
        }
        // 데이터가 있으면 객체를 생성해서 페이지 정보를 계산 후 에 pagination 정보를 저장해준다.
        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);

        List<PostResponse> list = postMapper.findAll(params);
        return new PagingResponse<>(list,pagination);
    }

    @Override
    public int count(SearchDto params) {
        return 0;
    }
}
