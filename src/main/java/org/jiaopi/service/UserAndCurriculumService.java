package org.jiaopi.service;

import org.jiaopi.pojo.UserAndCurriculum;

import java.util.List;

public interface UserAndCurriculumService {
    List<UserAndCurriculum> findUserAndCurriculaByUserIdEquals (Long userId);

    List<UserAndCurriculum> findUserAndCurriculaByCurriculumIdEquals(Long curriculumId);

    UserAndCurriculum save(UserAndCurriculum userAndCurriculum);

    UserAndCurriculum findUserAndCurriculaByCurriculumIdAndUserId(Long curriculumId, Long userId);
}
