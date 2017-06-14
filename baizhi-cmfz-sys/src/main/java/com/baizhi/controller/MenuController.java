package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
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
@RequestMapping("/menu")
public class MenuController {

    @Resource
    private MenuService menuService;
    /**
     * 验证登录
     */
    @ResponseBody
    @RequestMapping("/queryOne")
    public void queryAll(HttpServletResponse response) throws IOException {
        List<Menu> menuList = menuService.queryOne();
        String menuString = JSONObject.toJSONString(menuList);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(menuString);
    }
}
