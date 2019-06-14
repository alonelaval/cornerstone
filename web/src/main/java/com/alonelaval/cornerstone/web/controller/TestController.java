package com.alonelaval.cornerstone.web.controller;

import com.alonelaval.cornerstone.entity.base.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author huawei
 * @create 2018-07-13
 **/

@Slf4j
@Controller()
@RequestMapping("test")
public class TestController {


//    @RequestMapping("/")
//    public String root() {
////        log.info("userService:"+userService);
//        return "redirect:/index";
//    }

    @RequestMapping("/org/product1")
    public Object product1(Model model) {
        return ResponseEntity.ok().body(JsonResult.builder().message("测试版本1"));

    }
    @RequestMapping("/org/product2")
    public Object product2(Model model) {
        return ResponseEntity.ok().body(JsonResult.builder().message("测试版本2"));
    }


    @RequestMapping("/platform")
    public Object platform(Model model) {
        return ResponseEntity.ok().body(JsonResult.builder().message("平台"));

    }


    @RequestMapping("/user")
    public Object user(Model model) {
        return ResponseEntity.ok().body(JsonResult.builder().message("普通用户"));
    }



}
