package com.baizhi.controller;/*
package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.AlbumDATA;
import com.baizhi.entity.All;
import com.baizhi.entity.BannerDATA;
import com.baizhi.entity.EssayDATA;
import com.baizhi.service.AlbumDATAService;
import com.baizhi.service.BannerDATAService;
import com.baizhi.service.EssayService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import java.io.IOException;
import java.util.List;

*/
/**
 * Created by ljf on 2017/6/15.
 */

import com.baizhi.entity.EssayDATA;
import com.baizhi.service.EssayDATAService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Controller
@RequestMapping("/rest")
public class EssayDATAController {
    @Resource
    private EssayDATAService essayDATAService;
    @ResponseBody
    @RequestMapping(value="/queryAll",method={RequestMethod.GET})
    public void queryAll(HttpServletResponse response, String uid, String id) throws IOException {
        EssayDATA essayDATA = essayDATAService.queryOne(id);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(essayDATA);
    }
}
