package com.baizhi.controller;

import com.baizhi.entity.Third;
import com.baizhi.service.Impl.ThirdServcieImpl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ljf on 2017/6/16.
 */

public class ThirdController {

    @Resource
    private ThirdServcieImpl thirdServcie;

    public void queryOne(HttpServletResponse response, String id, String uid) throws IOException {
        Third third = thirdServcie.queryOne(id);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(third);
    }
}
