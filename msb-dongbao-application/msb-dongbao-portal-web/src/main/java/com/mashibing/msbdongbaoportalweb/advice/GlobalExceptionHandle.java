package com.mashibing.msbdongbaoportalweb.advice;

import com.baomidou.mybatisplus.extension.api.R;
import com.mashibing.msbdongbaocommonbase.result.ResultWrapper;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 何水锋
 * @version 1.0
 * 少壮不努力 只有搬砖命
 * @create 2022-04-18 22:24
 */
//@RestControllerAdvice
public class GlobalExceptionHandle {

    //@ExceptionHandler(Exception.class)//所有异常都会走进这个里面如果想更精细化的话你就写对应的异常，比如说空指针异常
    public ResultWrapper customException(){
        return ResultWrapper.builder().code(301).msg("统一异常").build();
    }
}
