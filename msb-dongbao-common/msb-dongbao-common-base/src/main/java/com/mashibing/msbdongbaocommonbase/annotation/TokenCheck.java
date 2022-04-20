package com.mashibing.msbdongbaocommonbase.annotation;

import jdk.nashorn.internal.ir.annotations.Reference;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 何水锋
 * @version 1.0
 * 少壮不努力 只有搬砖命
 * @create 2022-04-20 18:06
 */
@Target(ElementType.METHOD)//表示作用在方法上
@Retention(RetentionPolicy.RUNTIME)//注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在；
public @interface TokenCheck {
    //是否校验token
    boolean required() default true;
}
