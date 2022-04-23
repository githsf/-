package com.mashibing.msbdongbaoportalweb.controller;

import com.mashibing.msbdongbaocommonbase.annotation.TokenCheck;
import com.ramostear.captcha.HappyCaptcha;
import com.ramostear.captcha.support.CaptchaStyle;
import com.ramostear.captcha.support.CaptchaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: 何水锋
 * @Date: 2022/4/23/023 - 04 - 23 - 18:18
 * @Description: com.mashibing.msbdongbaoportalweb.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/code")
public class HappyCaptchaController {

    @GetMapping("/happy-captcha")
    @TokenCheck(required = false)//在拦截器里直接放行
    public void generatorCode(HttpServletRequest request, HttpServletResponse response) throws NoSuchFieldException {
        HappyCaptcha.require(request,response)
                .style(CaptchaStyle.ANIM)
                .type(CaptchaType.ARITHMETIC_ZH)
                .build().finish();

    }

    @GetMapping("/verify-happy")
    @TokenCheck(required = false)
    public String verify(String verifyCode, HttpServletRequest request) {
        boolean verification = HappyCaptcha.verification(request, verifyCode,true);
        System.out.println("11111111111111111:"+verification);
        if (verification){
            HappyCaptcha.remove(request);
            return "验证码校验通过";
        }
        return "验证码校验不通过";
    }
}
