package com.study.board.domain.user;

import java.util.List;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /**
     * 사용자 회원가입
     * @param user -사용자 정보
     */
    void saveUser(UserResponse user);

    /**
     * 사용자 상세정보 조회
     * @param uno -pk
     * @return 사용자 상세정보
     */
    UserResponse findByUno(Long uno);

    /**
     * 사용자 수정
     * @param user -사용자 정보
     */
    void updateUser(UserResponse user);

    /**
     * 사용자 탈퇴
     * @param uno -pk
     */
    void deleteUser(Long uno);

    /**
     * 사용자 상세정보 조회
     * @return 유저 리스트
     */
    List<User> findAllUser();
}
