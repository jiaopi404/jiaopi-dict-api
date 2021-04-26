package org.jiaopi.service.impl;

import org.jiaopi.dao.CurriculumMapper;
import org.jiaopi.pojo.Curriculum;
import org.jiaopi.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurriculumServiceImpl implements CurriculumService {

    @Autowired
    private CurriculumMapper curriculumMapper;

    @Override
    public Curriculum save(Curriculum curriculum) {
        return curriculumMapper.save(curriculum);
    }

    @Override
    public Curriculum getOne(Long id) {
        return curriculumMapper.findById(id).get();
    }
}
