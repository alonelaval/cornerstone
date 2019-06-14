package com.alonelaval.cornerstone.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huawei
 * @create 2018-11-02
 **/
@Controller
//@RequestMapping("kaptcha")
@Slf4j
public class IndexController {
    @RequestMapping("/")
    public String org(Model model) {
        return "org";
    }
    @RequestMapping("/platform")
    public String platform(Model model) {
        return "platform";
    }
}
