package com.study.board.service.user;

import com.study.board.domain.user.UserMapper;
import com.study.board.domain.user.UserResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserMapper userMapper;

    @Override
    public void saveUser(UserResponse user) {
        userMapper.saveUser(user);
    }

    @Override
    public UserResponse findByUno(Long uno) {
        return userMapper.findByUno(uno);
    }

    @Override
    public void updateUser(UserResponse user) {

    }

    @Override
    public void deleteUser(Long uno) {

    }

    @Override
    public List<User> findAllUser() {
        return null;
    }
}
