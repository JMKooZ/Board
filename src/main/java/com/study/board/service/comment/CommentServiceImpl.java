package com.study.board.service.comment;

import com.study.board.domain.comment.CommentMapper;
import com.study.board.domain.comment.CommentRequest;
import com.study.board.domain.comment.CommentResponse;
import com.study.board.domain.common.CommentSearchDto;
import com.study.board.domain.common.paging.Pagination;
import com.study.board.domain.common.paging.PagingResponse;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;

    @Override
    @Transactional
    public Long saveComment(final CommentRequest params) {
        commentMapper.saveComment(params);
        return params.getCno();
    }

    @Override
    public CommentResponse findByCno(final Long cno) {
        return commentMapper.findByCno(cno);
    }

    @Override
    @Transactional
    public Long updateComment(final CommentRequest params) {
        commentMapper.updateComment(params);
        return params.getCno();
    }

    @Override
    @Transactional
    public Long deleteByCno(final Long cno) {
        commentMapper.deleteByCno(cno);
        return cno;
    }

    @Override
    public PagingResponse<CommentResponse> findAll(final CommentSearchDto params) {
        int count = commentMapper.count(params);
        if(count < 1){
            return new PagingResponse<>(Collections.emptyList(), null);
        }
        Pagination pagination = new Pagination(count, params);
        List<CommentResponse> list = commentMapper.findAll(params);
        return new PagingResponse<>(list, pagination);
    }

    @Override
    public int count(final CommentSearchDto params) {
        return commentMapper.count(params);
    }
}
