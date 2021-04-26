package org.jiaopi.service.impl;

import org.jiaopi.dao.UserAndCurriculumMapper;
import org.jiaopi.pojo.UserAndCurriculum;
import org.jiaopi.service.UserAndCurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAndCurriculumServiceImpl implements UserAndCurriculumService {

    @Autowired
    private UserAndCurriculumMapper userAndCurriculumMapper;

    @Override
    public List<UserAndCurriculum> findUserAndCurriculaByUserIdEquals(Long userId) {
        return userAndCurriculumMapper.findUserAndCurriculaByUserIdEquals(userId);
    }

    @Override
    public List<UserAndCurriculum> findUserAndCurriculaByCurriculumIdEquals(Long curriculumId) {
        return userAndCurriculumMapper.findUserAndCurriculaByCurriculumIdEquals(curriculumId);
    }

    @Override
    public UserAndCurriculum save(UserAndCurriculum userAndCurriculum) {
        return userAndCurriculumMapper.save(userAndCurriculum);
    }

    @Override
    public UserAndCurriculum findUserAndCurriculaByCurriculumIdAndUserId(Long curriculumId, Long userId) {
        return userAndCurriculumMapper.findUserAndCurriculaByCurriculumIdAndUserId(curriculumId, userId);
    }
}
