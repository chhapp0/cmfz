package com.baizhi.controller;

import com.baizhi.entity.One;
import com.baizhi.service.Impl.OneServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ljf on 2017/6/15.
 */
@Controller
@RequestMapping("/one")
public class OneController {
    @Resource
    private OneServiceImpl oneService;


    @ResponseBody
    @RequestMapping( value="/queryAll",method={RequestMethod.GET})
    public void queryAll(HttpServletResponse response,String uid, String  type,String sub_type) throws IOException {
        One one = oneService.selectAll(uid, type, sub_type);
        System.out.println(one+"controller的one");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(one);
    }
}
