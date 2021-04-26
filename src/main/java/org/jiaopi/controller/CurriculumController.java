package org.jiaopi.controller;

import io.swagger.annotations.Api;
import org.jiaopi.entity.Result;
import org.jiaopi.entity.StatusCode;
import org.jiaopi.pojo.Curriculum;
import org.jiaopi.pojo.UserAndCurriculum;
import org.jiaopi.service.CurriculumService;
import org.jiaopi.service.UserAndCurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/curriculum")
@CrossOrigin
@Api(value = "curriculum controller", description = "curriculum controller")
public class CurriculumController {

    @Autowired
    private CurriculumService curriculumService;

    @Autowired
    private UserAndCurriculumService userAndCurriculumService;

    @PutMapping(value = "/save")
    public Result<Curriculum> save (@RequestBody Curriculum curriculum) {
        Curriculum curriculumToSave;
        if (curriculum.getId() != null) { // 编辑
            curriculumToSave = curriculumService.getOne(curriculum.getId());
            curriculumToSave.setName(curriculum.getName());
        } else { // 新增
            curriculumToSave = new Curriculum();
            curriculumToSave.setName(curriculum.getName());
            curriculumToSave.setCreateTime(new Date());
        }
        curriculumToSave.setUpdateTime(new Date());
        Curriculum curriculumSaved = curriculumService.save(curriculumToSave);
        return new Result<>(true, StatusCode.OK, "add success", curriculumSaved);
    }

    @GetMapping(value = "/getCurriculumByUserId")
    public Result<ArrayList<Curriculum>> getCurriculumByUserId (@RequestParam("userId") Long userId) {
        List<Curriculum> curricula = new ArrayList<>();
        List<UserAndCurriculum> userAndCurricula = userAndCurriculumService.findUserAndCurriculaByUserIdEquals(userId);
        for (UserAndCurriculum userAndCurriculum : userAndCurricula) {
            Curriculum curriculum = curriculumService.getOne(userAndCurriculum.getCurriculumId());
            curricula.add(curriculum);
        }
        return new Result<>(true, StatusCode.OK, "add success", curricula);
    }

    @GetMapping(value = "/getById")
    public Result<Curriculum> getById (@RequestParam("curriculumId") Long curriculumId) {
        Curriculum curriculum = curriculumService.getOne(curriculumId);
        return new Result<>(true, StatusCode.OK, "get success", curriculum);
    }
}
