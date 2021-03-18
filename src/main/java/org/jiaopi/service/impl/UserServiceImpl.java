package org.jiaopi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
//import org.jiaopi.dao.CurriculumMapper;
import org.jiaopi.dao.UserMapper;
//import org.jiaopi.pojo.Curriculum;
import org.jiaopi.pojo.User;
import org.jiaopi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

//    @Autowired
//    private CurriculumMapper curriculumMapper;

    @Override
    public User add(User user) {
//        Curriculum curriculum1 = user.getCurriculum();
//        Curriculum curriculum = curriculumMapper.save(user.getCurriculum());
//        User user1 = new User();
////        user1.setCurriculum(curriculum);
//        user1.setName(user.getName());
        return userMapper.save(user);
    }

    @Override
    public void delete(Long id) {
        userMapper.deleteById(id);
    }

    @Override
    public void update(User user) {
        userMapper.save(user);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    /**
     * 根据 openId 获取 user
     * @param openId
     * @return
     */
    @Override
    public User getUserByOpenId(String openId) {
        return userMapper.getUserByOpenId(openId);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public List<User> findList(User user) {
        return null;
    }

    @Override
    public PageInfo<User> findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(userMapper.findAll());
    }

    @Override
    public PageInfo<User> findPage(User user, int pageNum, int pageSize) {
        return null;
    }
}
