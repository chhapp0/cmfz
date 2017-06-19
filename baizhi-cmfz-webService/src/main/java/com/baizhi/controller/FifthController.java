package com.baizhi.controller;

import com.baizhi.entity.UserDATA;
import com.baizhi.service.UserService;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ljf on 2017/6/17.
 */


public class FifthController {
    @Resource
    private UserService userService;
    @ResponseBody
    private void queryOne(HttpServletResponse response, UserDATA userDATA) throws IOException {
        UserDATA userDATA2 = userService.queryUser(userDATA.getPhone());
        if (userDATA2 != null) {
            userService.add(userDATA);
            UserDATA userDATA1 = userService.queryUser(userDATA.getPhone());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(userDATA1);
        }else{
            response.setContentType("application/json;charset=utf-8");
        response.getWriter().print("'errno':'-200',errmsg:'手机号已注册'");
    }
    }

}
