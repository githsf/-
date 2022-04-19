package com.mashibing.msbdongbaocommonbase.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 何水锋
 * @version 1.0
 * 少壮不努力 只有搬砖命
 * @create 2022-04-18 20:12
 */
public enum StateCodeEunm {
    /**
     * 请求失败
     */
    FIAL(500,"请求失败"),
    /**
     * 请求成功
     */
    SUCCESS(200,"返回成功");

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    StateCodeEunm(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
