package com.mashibing.msbdongbaoportalweb.controller;

import com.mashibing.msbdongbaocommonbase.annotation.TokenCheck;
import com.mashibing.msbdongbaoportalweb.code.ImageCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @Auther: 何水锋
 * @Date: 2022/4/21/021 - 04 - 21 - 21:12
 * @Description: com.mashibing.msbdongbaoportalweb.controller
 * @version: 1.0
 *            控制器
 */
@RestController
@RequestMapping("/code")
public class VerifyCodeController {

    String attrName="verifyCode";

    @GetMapping("/generator")
    @TokenCheck(required = false)//在拦截器里直接放行
    public void generatorCode(HttpServletRequest request,HttpServletResponse response) throws NoSuchFieldException {
        try {
            ImageCode imageCode = ImageCode.getInstance();
            //验证码的值
            String code = imageCode.getCode();
            request.getSession().setAttribute(attrName,code);
            //验证码图片
            ByteArrayInputStream image = imageCode.getImage();

            response.setContentType("image/jpeg");
            byte[] bytes = new byte[1024];
            try (ServletOutputStream out = response.getOutputStream()){
                while (image.read(bytes) != -1){
                    out.write(bytes);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            System.out.println("异常");
        }

    }

    /**
     * 校验验证码
     * @param verifyCode
     * @param request
     * @return
     */
    @GetMapping("/verify")
    @TokenCheck(required = false)
    public String verify(String verifyCode, HttpServletRequest request) {
        String s = request.getSession().getAttribute(attrName).toString();
        System.out.println("11111111111111111:"+s);
        if (verifyCode.equals(s)){
            return "验证码校验通过";
        }
        return "验证码校验不通过";
    }
}
