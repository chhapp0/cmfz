package com.baizhi.controller;

import com.baizhi.dao.UserDATAMapper;
import com.baizhi.entity.UserDATA;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ljf on 2017/6/17.
 */
public class FourthController {
    @Resource
    private UserService userService;
    @Autowired
    private UserDATAMapper userDATAMapper;

    @ResponseBody
    public void login(HttpServletResponse response, UserDATA userDATA) throws IOException {
        UserDATA userDATA1 = userService.queryByName(userDATA);
        UserDATA userDB = userDATAMapper.selectByUserDATAname(userDATA.getPhone());
        if(userDB!=null) {
            String md5Code = userDATA.getPwd() + userDB.getSalt();
            if (md5Code.equals(userDB.getPwd())) {
                userDATA1.setId(userDB.getId());
                userDATA1.setCity(userDB.getCity());
                userDATA1.setDescription(userDB.getDescription());
                userDATA1.setFarmington(userDB.getFarmington());
                userDATA1.setGender(userDB.getGender());
                String location1 = userDB.getPpid().getPname() + userDB.getCcid().getName();
                userDATA1.setLocation(location1);
                userDATA1.setNickname(userDB.getNickname());
                userDATA1.setPhone(userDB.getPhone());
                userDATA1.setPwd(md5Code);
                userDATA1.setProvince(userDB.getProvince());
                userDATA1.setCity(userDB.getCity());
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().print(userDATA1);
            }else{
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().print("'errno':'-200',errmsg:'密码错误'");
            }
        }

        }
    }


