package com.alonelaval.cornerstone.web.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.alonelaval.cornerstone.cache.KaptchaCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
/**
 * @author huawei
 * @create 2018-07-18
 **/
@Controller
//@RequestMapping("kaptcha")
@Slf4j
public class KaptchaController {


    @RequestMapping("/kaptcha")
    public void getKaptchaImage(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        //String code = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        response.setDateHeader("Expires", 0);
        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
        // return a jpeg
        response.setContentType("image/jpeg");
        // create the text for the image
        String capText = captchaProducer.createText();
        log.info("登录验证码:{}",capText);
        // store the text in the session
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        KaptchaCache.getInstance().put(capText.toLowerCase());
        // create the image with the text
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out;
        try {
            out = response.getOutputStream();
            // write the data out
            ImageIO.write(bi, "jpg", out);

            out.flush();
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Autowired
    private Producer captchaProducer;
}
