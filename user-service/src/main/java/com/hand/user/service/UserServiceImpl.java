package com.hand.user.service;

import com.hand.user.entity.User;
import com.hand.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liuqixin
 * @date 2019/7/26 14:24
 */
@Component
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getList() {
        return userRepository.findAll();
    }

    @Override
    public User queryById(Long aLong) {
        return userRepository.getOne(aLong);
    }

    @Override
    public User create(User object) {
        return userRepository.save(object);
    }

    @Override
    public User update(User object) {
        return userRepository.save(object);
    }

    @Override
    public void delete(Long aLong) {
        userRepository.deleteById(aLong);
    }
}
