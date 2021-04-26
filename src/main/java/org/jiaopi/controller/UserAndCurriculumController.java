package org.jiaopi.controller;

import io.swagger.annotations.Api;
import org.jiaopi.entity.Result;
import org.jiaopi.entity.StatusCode;
import org.jiaopi.pojo.Curriculum;
import org.jiaopi.pojo.UserAndCurriculum;
import org.jiaopi.service.UserAndCurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/userAndCurriculum")
@CrossOrigin
@Api(value = "user_and_curriculum controller", description = "user_and_curriculum controller")
public class UserAndCurriculumController {

    @Autowired
    private UserAndCurriculumService userAndCurriculumService;

    @PutMapping(value = "/save")
    public Result<Curriculum> save (@RequestBody UserAndCurriculum userAndCurriculum) {
        if (userAndCurriculum.getUserId() == null) {
            return new Result<>(false, StatusCode.ERROR, "user 参数缺少", userAndCurriculum);
        }
        if (userAndCurriculum.getCurriculumId() == null) {
            return new Result<>(false, StatusCode.ERROR, "curriculum 参数缺少", userAndCurriculum);
        }
        UserAndCurriculum userAndCurriculumInDatabase = userAndCurriculumService.findUserAndCurriculaByCurriculumIdAndUserId(userAndCurriculum.getCurriculumId(), userAndCurriculum.getUserId());
        UserAndCurriculum userAndCurriculumSaved = null;
        if (userAndCurriculumInDatabase == null) {
            userAndCurriculumSaved = userAndCurriculumService.save(userAndCurriculum);
            return new Result<>(true, StatusCode.OK, "add success", userAndCurriculumSaved);
        } else {
            return new Result<>(false, StatusCode.ERROR, "有重复项", null);
        }
    }
}
