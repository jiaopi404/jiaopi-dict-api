package org.jiaopi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jiaopi.entity.Result;
import org.jiaopi.entity.StatusCode;
import org.jiaopi.pojo.Curriculum;
import org.jiaopi.pojo.User;
import org.jiaopi.service.CurriculumService;
import org.jiaopi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin
@Api(value = "user service", description = "user api")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private CurriculumService curriculumService;

    @GetMapping
    @ApiOperation("find all")
    public Result<List<User>> findAll () {
        List<User> users = userService.findAll();
        return new Result<>(true, StatusCode.OK, "success", users);
    }

    @GetMapping(value = "/{id}")
    public Result<User> findById (@PathVariable("id") Long id) {
        return new Result<>(true, StatusCode.OK, "find success", userService.findById(id));
    }

    @PostMapping(value = "/add")
    public Result<Boolean> add (@RequestBody User user) {
//        System.out.println(user);
//        System.out.println(1 + 1);
        // 1. save curriculum
        Curriculum curriculumToSave = user.getCurriculum();
        Curriculum curriculumSaved = null;
        if (curriculumToSave != null) {
            curriculumSaved = curriculumService.add(curriculumToSave);
        }
        User userToSave = new User();
        userToSave.setName(user.getName());
        if (curriculumSaved != null) {
            userToSave.setCurriculum(curriculumSaved);
        }
        userService.add(userToSave);
        return new Result<>(true, StatusCode.OK, "add success", true);
    }
}
