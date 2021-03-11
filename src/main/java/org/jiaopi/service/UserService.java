package org.jiaopi.service;

import com.github.pagehelper.PageInfo;
import org.jiaopi.pojo.User;

import java.util.List;

public interface UserService {
    void add (User user);

    void delete (Long id);

    void update (User user);

    List<User> findAll ();

    User findById (Long id);

    List<User> findList (User user);

    PageInfo<User> findPage (int pageNum, int pageSize);

    PageInfo<User> findPage (User user, int pageNum, int pageSize);
}
