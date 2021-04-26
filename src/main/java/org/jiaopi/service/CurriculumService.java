package org.jiaopi.service;

import org.jiaopi.pojo.Curriculum;

public interface CurriculumService {
    Curriculum save (Curriculum curriculum);

    Curriculum getOne (Long id);
}
