package com.mashibing.msbdongbaoumsapi.entity.dto;/*
@author 马大吉
@date 2021-12-20 21:34
*/

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class UmsMemberLoginParamDTO implements Serializable {
    private String username;
    private String password;
}
