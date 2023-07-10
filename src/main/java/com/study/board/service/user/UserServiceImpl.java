package com.study.board.service.user;

import com.study.board.domain.user.UserMapper;
import com.study.board.domain.user.UserRequest;
import com.study.board.domain.user.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    @Override
    public Long saveUser(UserRequest params) {
        params.encodingPassword(passwordEncoder);
        userMapper.saveUser(params);
        return params.getUno();
    }

    @Override
    public UserResponse findById(String loginId) {
        return userMapper.findById(loginId);
    }

    @Override
    public Long update(UserRequest params) {
        params.encodingPassword(passwordEncoder);
        userMapper.update(params);
        return params.getUno();
    }

    @Override
    public Long deleteByUno(Long uno) {
        userMapper.deleteByUno(uno);
        return uno;
    }

    @Override
    public int countById(String loginId) {
        return userMapper.countById(loginId);
    }

    /**
     * 로그인
     * @param loginId - 로그인 ID
     * @param password - 비밀번호
     * @return 회원 상세정보
     */
    public UserResponse loginUser(final String loginId, final String password){
        UserResponse user = userMapper.findById(loginId);
        String encodedPassword = (user == null) ? "" : user.getPassword();

        if(user == null || !passwordEncoder.matches(password, encodedPassword)){
            return null;
        }

        user.clearPassword();
        return user;
    }
}
