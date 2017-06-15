package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.City;
import com.baizhi.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by ljf on 2017/6/15.
 */
@Controller
@RequestMapping("/city")
public class CityController  {
@Resource
private CityService cityService;

    @RequestMapping("/queryAllAdd")
    @ResponseBody
    public void queryAll(HttpServletResponse response,String id) throws IOException {
        List<City> cityList = cityService.queryProvince(id);
        String cityString = JSONObject.toJSONString(cityList);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(cityString);
    }
}
