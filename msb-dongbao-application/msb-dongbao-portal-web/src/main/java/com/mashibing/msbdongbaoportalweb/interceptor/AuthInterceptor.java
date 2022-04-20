package com.mashibing.msbdongbaoportalweb.interceptor;


import com.mashibing.msbdongbaocommonbase.TokenException;
import com.mashibing.msbdongbaocommonbase.annotation.TokenCheck;
import com.mashibing.msbdongbaocommonutil.JWTUtil;
import javafx.fxml.LoadException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.lang3.StringUtils;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author 何水锋
 * @version 1.0
 * 少壮不努力 只有搬砖命
 * @create 2022-04-20 21:49
 */

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        //判断token是否为空
        if (StringUtils.isBlank(token)){
            throw new TokenException( "token 为空");
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //判断这个方法是否有这个注释
        if (method.isAnnotationPresent(TokenCheck.class)){
            TokenCheck annotation = method.getAnnotation(TokenCheck.class);
            //判断是否为true
            if (annotation.required()){
                //校验token
                try {
                    JWTUtil.parseToken(token);
                    return true;
                }catch (Exception e){
                    throw new TokenException("Token 异常") ;
                }

            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
