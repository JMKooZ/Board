package com.study.board.domain.user;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private Long uno;
    private String email;
    private String name;
    private String passWord;
    private String nickName;
    private String gender;
    private String phoneNumber;
    private String birth;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
