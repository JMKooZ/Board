package com.study.board.service.comment;

import static org.junit.jupiter.api.Assertions.*;

import com.study.board.domain.comment.CommentMapper;
import com.study.board.domain.comment.CommentRequest;
import com.study.board.domain.comment.CommentResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommentServiceImplTest {
    @Autowired
    CommentMapper commentMapper;

    @Test
    public void insert() throws Exception {
        //given
        for(int i = 1; i < 101 ; i++){
            CommentRequest build = CommentRequest.builder().bno(1002L).writer("test" + i)
                .content("test" + i).build();
            commentMapper.saveComment(build);
        }
        //when

        //then
     }
}