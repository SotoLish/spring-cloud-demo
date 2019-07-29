package com.hand.user.repository;

import com.hand.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User 持久层接口
 * @author liuqixin
 * @date 2019/7/26 14:24
 */
public interface UserRepository extends JpaRepository<User,Long> {

}
