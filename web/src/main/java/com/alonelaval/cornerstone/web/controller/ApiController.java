package com.alonelaval.cornerstone.web.controller;

import com.alonelaval.cornerstone.entity.base.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author huawei
 * @create 2018-07-15
 **/
@Controller()
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/hello")
    @ResponseBody
    public Object hello() {
        return  JsonResult.builder().message("hello world").build();
    }

    @PostMapping("/user")
    @ResponseBody
    public Object user() {
        return  JsonResult.builder().message("user").build();
    }

    @PostMapping("/classes")
    @ResponseBody
    public Object classes() {
        return JsonResult.builder().message("classes").build();
    }

    @PostMapping("/org")
    @ResponseBody
    public Object org() {
        return JsonResult.builder().message("org").build();
    }

    @PostMapping("/platform")
    @ResponseBody
    public Object platform() {
        return JsonResult.builder().message("platform").build();
    }
}
