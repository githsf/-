package com.mashibing.msbdongbaoportalweb.controller;

import com.mashibing.msbdongbaocommonbase.annotation.TokenCheck;
import com.ramostear.captcha.HappyCaptcha;
import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.ChineseCaptcha;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @Auther: 何水锋
 * @Date: 2022/4/23/023 - 04 - 23 - 20:58
 * @Description: com.mashibing.msbdongbaoportalweb.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/code")
public class EasyCaptchaController {

    @GetMapping("/easy-captcha")
    @TokenCheck(required = false)//在拦截器里直接放行
    public void generatorCode(HttpServletRequest request, HttpServletResponse response) throws NoSuchFieldException {
        try {
            //基础
            CaptchaUtil.out(request,response);
            //算数
            ArithmeticCaptcha arithmeticCaptcha = new ArithmeticCaptcha(200,50);
            //三个数运算
            arithmeticCaptcha.setLen(3);
            //这是结果如果要写在redis中就将text存到redis中
            String text = arithmeticCaptcha.text();
            CaptchaUtil.out(arithmeticCaptcha,request,response);

            //写中文
            ChineseCaptcha chineseCaptcha = new ChineseCaptcha(200,50);
            CaptchaUtil.out(chineseCaptcha,request,response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/verify-easy")
    @TokenCheck(required = false)
    public String verify(String verifyCode, HttpServletRequest request) {
        boolean ver = CaptchaUtil.ver(verifyCode, request);
        System.out.println("11111111111111111:"+ver);
        if (ver){
            CaptchaUtil.clear(request);
            return "验证码校验通过";
        }
        return "验证码校验不通过";
    }


    //将验证码存到redis中

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @GetMapping("/generator-redis")
    @TokenCheck(required = false)
    public void generatorCodeRedis(HttpServletRequest request, HttpServletResponse response) {
        //设置验证码的宽和高
        SpecCaptcha specCaptcha = new SpecCaptcha(100,50);
        String text = specCaptcha.text();
        System.out.println("验证码："+text);
        String s = UUID.randomUUID().toString();
        String sessionid = request.getSession().getId();
        //将数据存到redis中
        stringRedisTemplate.opsForValue().set(sessionid,text);
        try {
            CaptchaUtil.out(specCaptcha,request,response);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @GetMapping("/verify-redis")
    @TokenCheck(required = false)
    public String verifyRedis(String verifyCode, HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        //从redis中取出数据
        String c = stringRedisTemplate.opsForValue().get(sessionId);

        if (verifyCode.equals(c)) {
            HappyCaptcha.remove(request);
            return "通过";
        }

        return "不通过";
    }

}
