package com.mashibing.msbdongbaoportalweb.advice;

import com.mashibing.msbdongbaocommonbase.result.ResultWrapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author 何水锋
 * @version 1.0
 * 少壮不努力 只有搬砖命
 * @create 2022-04-18 22:14
 */
@ControllerAdvice //aop面向切面当我们写了错误提示的时候如果出现错误  会自动进入这个里面
public class ValidateHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, 
                                                                  HttpHeaders headers, 
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        StringBuilder sb = new StringBuilder();
        //遍历错误提示
        for (FieldError fieldError:ex.getBindingResult().getFieldErrors()) {
            String defaultMessage = fieldError.getDefaultMessage();
            sb.append(sb);
        }
        return new ResponseEntity(ResultWrapper.builder().code(123).msg(sb.toString()).build(),HttpStatus.OK);
    }
}
