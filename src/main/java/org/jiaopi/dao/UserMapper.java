package org.jiaopi.dao;

import org.jiaopi.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//import org.springframework.stereotype.Repository;

public interface UserMapper extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    User getUserByOpenId(String openId);
}
