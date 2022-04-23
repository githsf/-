package com.mashibing.msbdongbaoportalweb.controller;

import com.baomidou.kaptcha.Kaptcha;
import com.baomidou.kaptcha.exception.KaptchaNotFoundException;
import com.mashibing.msbdongbaocommonbase.annotation.TokenCheck;
import com.mashibing.msbdongbaocommonbase.result.ResultWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: 何水锋
 * @Date: 2022/4/23/023 - 04 - 23 - 22:44
 * @Description: com.mashibing.msbdongbaoportalweb.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/code")
public class KcaptchaController {

    @Autowired
    private Kaptcha kaptcha;

    @GetMapping("/k-captcha")
    @TokenCheck(required = false)//在拦截器里直接放行
    public void generatorCode(HttpServletRequest request, HttpServletResponse response) throws NoSuchFieldException {
        kaptcha.render();//获取验证码
    }

    @GetMapping("/verify-kcaptcha")
    @TokenCheck(required = false)
    public ResultWrapper verify(String verifyCode, HttpServletRequest request) {

        try {
            boolean  validate = kaptcha.validate(verifyCode);
            //也可以设置过期时间
            //boolean  validate = kaptcha.validate(verifyCode,50);
            if (validate){
                return ResultWrapper.getSuccessBuilder().date("验证码通过").build();
                //或者
                //return "验证码通过";
            }
        } catch (KaptchaNotFoundException e) {
            e.printStackTrace();
        }
        return ResultWrapper.getFialBuilder().date("验证码不通过").build();
        //return "验证码不通过";
    }
}
