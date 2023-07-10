package com.study.board.domain.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /**
     * 회원 정보 저장 (회원가입)
     * @param params - 회원 정보
     */
    void saveUser(UserRequest params);

    /**
     * 회원 상세정보 조회
     * @param loginId - UK
     * @return 회원 상세정보
     */
    UserResponse findById(String loginId);

    /**
     * 회원 정보 수정
     * @param params - 회원 정보
     */
    void update(UserRequest params);

    /**
     * 회원 정보 삭제 (회원 탈퇴)
     * @param uno - PK
     */
    void deleteByUno(Long uno);

    /**
     * 회원 수 카운팅 (ID 중복 체크)
     * @param loginId - UK
     * @return 회원 수
     */
    int countById(String loginId);
}
