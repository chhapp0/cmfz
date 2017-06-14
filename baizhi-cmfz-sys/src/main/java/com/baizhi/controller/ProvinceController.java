package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Moduleobject;
import com.baizhi.entity.Province;
import com.baizhi.service.ProvinceService;
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
@RequestMapping("/province")
public class ProvinceController {
    @Resource
    private ProvinceService provinceService;

    @RequestMapping("/queryAll")
    @ResponseBody
    public void queryAll(HttpServletResponse response,Integer page,Integer rows) throws IOException {
        Page<Province> pages = provinceService.queryAll(page, rows);
        Moduleobject moduleobject=new Moduleobject();
        moduleobject.setRows(pages.getResult());
        moduleobject.setTotal(pages.getTotal());
        String provinceString = JSONObject.toJSONString(moduleobject);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(provinceString);
    }

    @RequestMapping("/queryOne")
    @ResponseBody
    public void queryOne(String id,HttpServletResponse response) throws IOException {
        Province province = provinceService.queryOne(id);
        String provinceString = JSONObject.toJSONString(province);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(provinceString);
    }
}
