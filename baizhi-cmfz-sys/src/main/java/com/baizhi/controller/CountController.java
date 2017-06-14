package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Counter;
import com.baizhi.entity.Moduleobject;
import com.baizhi.service.CounterService;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ljf on 2017/6/13.
 */
@Controller
@RequestMapping("/count")
public class CountController {
    @Resource
    private CounterService counterService;

    @RequestMapping("/queryAll")
    @ResponseBody
    public void queryAll(HttpServletResponse response,Integer page,Integer rows) throws IOException {
        Page<Counter> pages = counterService.queryAll(page, rows);
        Moduleobject moduleobject = new Moduleobject();
        moduleobject.setRows(pages.getResult());
        moduleobject.setTotal(pages.getTotal());

        String countListString = JSONObject.toJSONStringWithDateFormat(moduleobject, "yyyy-MM-dd");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(countListString);
    }

  /* @RequestMapping("/queryOne")
    @ResponseBody
    public void queryOne(String id,HttpServletResponse response) throws IOException {
       Counter counter = counterService.queryOne(id);
       String countString = JSONObject.toJSONStringWithDateFormat(counter, "yyyy-MM-dd");
       response.setContentType("application/json;charset=utf-8");
       response.getWriter().print(countString);
   }*/
   /* @RequestMapping("/add")
    public void   add(Counter counter) {
        counterService.add(counter);
        //return "/back/page/user/counter/show.jsp";
    }
    @RequestMapping("/delete")
    public void   delete(String id) {
        counterService.delete(id);
        //return "/back/page/user/counter/show.jsp";
    }
    @RequestMapping("/update")
    public void   update(Counter counter) {
        counterService.update(counter);
        //return "/back/page/user/counter/show.jsp";
    }*/


}
