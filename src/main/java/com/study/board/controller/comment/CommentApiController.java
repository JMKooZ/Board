package com.study.board.controller.comment;

import com.study.board.domain.comment.CommentRequest;
import com.study.board.domain.comment.CommentResponse;
import com.study.board.domain.common.CommentSearchDto;
import com.study.board.domain.common.SearchDto;
import com.study.board.domain.common.paging.PagingResponse;
import com.study.board.service.comment.CommentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentApiController {
    private final CommentService commentService;

    @PostMapping("/posts/{bno}/comments")
    public CommentResponse saveComment(@PathVariable final Long bno, @RequestBody final CommentRequest params){
        Long cno = commentService.saveComment(params);
        return commentService.findByCno(cno);
    }

    @GetMapping("/posts/{bno}/comments")
    public PagingResponse<CommentResponse> findAllComment(@PathVariable final Long bno, final CommentSearchDto params){
        return commentService.findAll(params);
    }

    @GetMapping("/posts/{bno}/comments/{cno}")
    public CommentResponse findByCno(@PathVariable final Long bno, @PathVariable final Long cno){
        return commentService.findByCno(cno);
    }

    @PatchMapping("/posts/{bno}/comments/{cno}")
    public CommentResponse updateComment(@PathVariable final Long bno, @PathVariable final Long cno,
        @RequestBody final CommentRequest params){
        commentService.updateComment(params);
        return commentService.findByCno(cno);
    }

    @DeleteMapping("/posts/{bno}/comments/{cno}")
    public Long deleteComment(@PathVariable final Long bno, @PathVariable final Long cno){
        return commentService.deleteByCno(cno);
    }
}
