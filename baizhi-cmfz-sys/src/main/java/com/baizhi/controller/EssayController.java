package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Essay;
import com.baizhi.service.EssayService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by ljf on 2017/6/13.
 */
@Controller
@RequestMapping("/essay")
public class EssayController {
    @Resource
    private EssayService essayService;


    @RequestMapping("/queryAll")
    @ResponseBody
    public void queryAll(HttpServletResponse response) throws IOException {
        List<Essay> essayList = essayService.queryAll();
        String essayListString = JSONObject.toJSONStringWithDateFormat(essayList, "yyyy-MM-dd");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(essayListString);
    }

    @RequestMapping("/queryOne")
    @ResponseBody
    public void queryOne(HttpServletResponse response,String id) throws IOException {
        Essay essay = essayService.queryOne(id);
        String essayString = JSONObject.toJSONStringWithDateFormat(essay, "yyyy-MM-dd");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(essayString);
    }

    @RequestMapping("/add")
    public String add(Essay essay){
        essayService.add(essay);
        return "/back/page/essay/info/show.jsp";
    }
    @RequestMapping("/update")
    public String update(Essay essay){
        essayService.update(essay);
        return "/back/page/essay/info/show.jsp";
    }
    @RequestMapping("/delte")
    public String delte(String id){
        essayService.delete(id);
        return "/back/page/essay/info/show.jsp";
    }

}
