package org.jiaopi.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import org.jiaopi.entity.Result;
import org.jiaopi.entity.StatusCode;
import org.jiaopi.pojo.User;
import org.jiaopi.service.UserService;
import org.jiaopi.service.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/wx")
@CrossOrigin
@Api(value = "wx controller", description = "wx controller")
public class WxController {
    @Autowired
    private WxService wxService;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result<User> wxLogin (@RequestBody JSONObject jsonObject) {
        String apiKey = jsonObject.getString("apiKey");
        String jsCode = jsonObject.getString("jsCode");
        if (StringUtils.isEmpty(apiKey) || StringUtils.isEmpty(jsCode)) {
            return new Result<>(true, StatusCode.ERROR, "参数为空", null);
        }
        // 微信登录
        JSONObject responseJSONObject = wxService.wxLogin(apiKey, jsCode);
        // 登录成功后，根据获取到的 openId 查询 user 表
        String openId = responseJSONObject.getString("openid");
        // 1. 能查询得到，返回 user
        User user = userService.getUserByOpenId(openId);
        if (user != null) {
            return new Result<>(true, StatusCode.OK, "登录成功, 已有账户！", user);
        }
        // 2. 查询不到，创建 user
        user = new User();
        String currentTime = new Date().getTime() + ""; // 用户名后缀
        user.setName("用户名" +
                currentTime.substring(currentTime.length() - 5, currentTime.length() - 1)
        ); // 设置用户名
        user.setOpenId(openId);
        user = userService.add(user); // 调用添加 user 服务
        return new Result<>(true, StatusCode.OK, "注册并登录成功", user);
    }
}
