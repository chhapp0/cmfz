package com.baizhi.controller;

import com.baizhi.entity.One;
import com.baizhi.service.Impl.OneServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ljf on 2017/6/15.
 */
public class OneController {
    @Resource
    private OneServiceImpl oneService;
    @ResponseBody
    @RequestMapping("/queryAll")
    public void queryAll(HttpServletResponse response,String uid, String  type,String sub_type) throws IOException {
        One one = oneService.selectAll(uid, type, sub_type);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(one);
    }
}
