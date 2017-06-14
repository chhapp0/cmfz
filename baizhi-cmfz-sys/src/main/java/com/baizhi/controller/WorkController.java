package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Work;
import com.baizhi.service.WorkService;
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
@RequestMapping("/work")
public class  WorkController {
    @Resource
    private WorkService workService;

    @ResponseBody
    @RequestMapping("/queryAll")
    public void queryAll(HttpServletResponse response) throws IOException {
        List<Work> workList = workService.queryAll();
        final String worklistString = JSONObject.toJSONStringWithDateFormat(workList, "yyyy-MM-dd");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(worklistString);
    }

    @ResponseBody
    @RequestMapping("/queryOne")
    public void queryOne(String id,HttpServletResponse response) throws IOException {
        Work work = workService.queryOne(id);
        String workString = JSONObject.toJSONString(work);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(workString);
    }

    @RequestMapping("/add")
    public String add(Work work){
        workService.add(work);
        return "/back/page/user/work/show.jsp";
    }
    @RequestMapping("/delete")
    public String delete(String id){
        workService.delete(id);
        return "/back/page/user/work/show.jsp";
    }
    @RequestMapping("/update")
    public String update(Work work){
        workService.update(work);
        return "/back/page/user/work/show.jsp";
    }

}
