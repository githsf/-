package com.mashibing.msbdongbaocommonbase.result;

import com.mashibing.msbdongbaocommonbase.enums.StateCodeEunm;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 何水锋
 * @version 1.0
 * 少壮不努力 只有搬砖命
 * @create 2022-04-18 20:15
 */
@Data
@Builder //返回自己不像别的想法调用之后返回viod或者对象
public class ResultWrapper<T> implements Serializable {

    private int code;
    private String msg;
    private T date;

    /**
     * 返回成功的包装
     * @return
     */
    public static ResultWrapper.ResultWrapperBuilder getSuccessBuilder(){
        return ResultWrapper.builder().code(StateCodeEunm.SUCCESS.getCode()).msg(StateCodeEunm.SUCCESS.getMsg());
    }

    /**
     * 返回用户存在
     * @return
     */
    public static ResultWrapper.ResultWrapperBuilder getExistUser(){
        return ResultWrapper.builder().code(StateCodeEunm.EXISTUSER.getCode()).msg(StateCodeEunm.EXISTUSER.getMsg());
    }


    /**
     * 返回用户不存在
     * @return
     */
    public static ResultWrapper.ResultWrapperBuilder getNotExistUser(){
        return ResultWrapper.builder().code(StateCodeEunm.NOTEXISTUSER.getCode()).msg(StateCodeEunm.NOTEXISTUSER.getMsg());
    }

    /**
     * 返回密码错误
     * @return
     */
    public static ResultWrapper.ResultWrapperBuilder getPassowrdError(){
        return ResultWrapper.builder().code(StateCodeEunm.PASSWORDERROR.getCode()).msg(StateCodeEunm.PASSWORDERROR.getMsg());
    }


    /**
     * 返回失败的包装
     * @return
     */
    public static ResultWrapper.ResultWrapperBuilder getFialBuilder(){
        return ResultWrapper.builder().code(StateCodeEunm.FIAL.getCode()).msg(StateCodeEunm.FIAL.getMsg());
    }

}
