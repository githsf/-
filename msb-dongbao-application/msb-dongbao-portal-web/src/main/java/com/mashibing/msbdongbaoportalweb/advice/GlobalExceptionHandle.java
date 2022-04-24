package com.mashibing.msbdongbaoportalweb.advice;

import com.baomidou.kaptcha.exception.KaptchaException;
import com.baomidou.kaptcha.exception.KaptchaIncorrectException;
import com.baomidou.kaptcha.exception.KaptchaNotFoundException;
import com.baomidou.kaptcha.exception.KaptchaTimeoutException;
import com.mashibing.msbdongbaocommonbase.TokenException;
import com.mashibing.msbdongbaocommonbase.result.ResultWrapper;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 何水锋
 * @version 1.0
 * 少壮不努力 只有搬砖命
 * @create 2022-04-18 22:24
 */
@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(ArithmeticException.class)//所有异常都会走进这个里面如果想更精细化的话你就写对应的异常，比如说空指针异常
    public ResultWrapper customException(){
        return ResultWrapper.builder().code(301).msg("统一异常").build();
    }

    /**
     * 自动以token异常
     * @param e
     * @return
     */
    @ExceptionHandler(TokenException.class)
    public ResultWrapper loginTokenException(Exception e){
        return ResultWrapper.getFialBuilder().msg(e.getMessage()).build();
    }
    @ExceptionHandler(KaptchaException.class)
    public String kcaptchaException(KaptchaException e){
        if (e instanceof KaptchaTimeoutException){
            return "超时";
        }else if (e instanceof KaptchaIncorrectException){
            return "不正确";
        }else if (e instanceof KaptchaNotFoundException){
            return "没找到";
        }else {
            return "反正错了";
        }
    }
}
