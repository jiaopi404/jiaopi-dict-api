package org.jiaopi.dao;

import org.jiaopi.pojo.UserAndCurriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UserAndCurriculumMapper extends JpaRepository<UserAndCurriculum, Long>, JpaSpecificationExecutor<UserAndCurriculum> {
    /**
     * 根据 userId 获取 s
     * @param userId
     * @return
     */
    List<UserAndCurriculum> findUserAndCurriculaByUserIdEquals(Long userId);

    /**
     * 根据 curriculumId 查询关联表
     * @param curriculumId
     * @return
     */
    List<UserAndCurriculum> findUserAndCurriculaByCurriculumIdEquals(Long curriculumId);

    /**
     * findUserAndCurriculaByCurriculumIdAndUserId
     * @param curriculumId
     * @param userId
     * @return
     */
    UserAndCurriculum findUserAndCurriculaByCurriculumIdAndUserId(Long curriculumId, Long userId);
}
