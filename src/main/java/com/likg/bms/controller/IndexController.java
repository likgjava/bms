package com.likg.bms.controller;

import com.alibaba.fastjson.JSONObject;
import com.likg.bms.common.domain.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by likg on 2016-09-02.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

//    @Resource
//    private StatService statService;

    private static AtomicLong indexCount = new AtomicLong();

    @ResponseBody
    @RequestMapping("/login")
    public JsonResult uploadMsgCount(String username, String password) {
        log.info("login receive msg: {}", username);

        JsonResult result = JsonResult.getInstance();
        try {
            //解析JSON数据
            result.setData("hello");

        } catch (Exception e) {
            result = JsonResult.getFailResult(1001, e.toString());
            log.error("login error.", e);
        }
        return result;
    }


    @RequestMapping("/index")
    public ModelAndView index() {
        Map<String, Object> model = new HashMap<>();
        indexCount.incrementAndGet();
        log.info("indexCount={}", indexCount);

        model.put("totalSingle", 1);

        return new ModelAndView("view/index", model);
    }

    @ResponseBody
    @RequestMapping("/profile")
    public JsonResult profile(String username, String password) {
        log.info("login receive msg: {}", username);

        JsonResult result = JsonResult.getInstance();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("userId", "1");
            jsonObject.put("username", "tom");
            jsonObject.put("age", 20);
            result.setData(jsonObject);
        } catch (Exception e) {
            result = JsonResult.getFailResult(1001, e.toString());
            log.error("profile error.", e);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/logout")
    public JsonResult logout(String username) {
        log.info("login receive msg: {}", username);

        JsonResult result = JsonResult.getInstance();
        try {
            result.setMsg("退出成功！");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("userId", "1");
            result.setData(jsonObject);
        } catch (Exception e) {
            result = JsonResult.getFailResult(1001, e.toString());
            log.error("logout error.", e);
        }
        return result;
    }
}
