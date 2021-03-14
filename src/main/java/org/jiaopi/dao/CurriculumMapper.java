package org.jiaopi.dao;

import org.jiaopi.pojo.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CurriculumMapper extends JpaRepository<Curriculum, Long>, JpaSpecificationExecutor<Curriculum> {
}
