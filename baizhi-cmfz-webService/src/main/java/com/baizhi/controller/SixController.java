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
public class SixController {
    @Resource
    private UserService userService;
    @ResponseBody
    public void update(HttpServletResponse response,String uid, String gender, String photo, String location , String description  , String  nickname, String pid, String cid , String password) throws IOException {
        if(uid!=null){
            //UserDATA userDATA=new UserDATA();
            UserDATA userDATA = userService.queryUserDATA(uid);
            userDATA.setId(uid);
            userDATA.setCity(cid);
            userDATA.setProvince(pid);
            userDATA.setPwd(password);
            userDATA.setDescription(description);
            userDATA.setGender(gender);
            userDATA.setNickname(nickname);
            userService.update(userDATA);
            UserDATA userDATA1 = userService.queryUser(userDATA.getPhone());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(userDATA1);
        }else{
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print("'errno':'-200',errmsg:'手机号已注册'");
        }
    }
}
