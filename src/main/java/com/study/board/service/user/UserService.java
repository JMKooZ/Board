package com.study.board.service.user;

import com.study.board.domain.user.UserMapper;
import com.study.board.domain.user.UserRequest;
import com.study.board.domain.user.UserResponse;

public interface UserService {
    /**
     * 회원 정보 저장 (회원가입)
     * @param params - 회원 정보
     */
    Long saveUser(final UserRequest params);

    /**
     * 회원 상세정보 조회
     * @param loginId - UK
     * @return 회원 상세정보
     */
    UserResponse findById(final String loginId);

    /**
     * 회원 정보 수정
     * @param params - 회원 정보
     */
    Long update(final UserRequest params);

    /**
     * 회원 정보 삭제 (회원 탈퇴)
     * @param uno - PK
     */
    Long deleteByUno(final Long uno);

    /**
     * 회원 수 카운팅 (ID 중복 체크)
     * @param loginId - UK
     * @return 회원 수
     */
    int countById(final String loginId);

    UserResponse loginUser(final String loginId, final String password);
}
