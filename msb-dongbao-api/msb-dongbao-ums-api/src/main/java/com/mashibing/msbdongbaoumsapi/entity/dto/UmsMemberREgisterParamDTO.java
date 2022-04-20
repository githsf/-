package com.mashibing.msbdongbaoumsapi.entity.dto;/*
@author 马大吉
@date 2021-12-20 21:34
*/

import lombok.Data;
import lombok.ToString;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@ToString
public class UmsMemberREgisterParamDTO implements Serializable {
    @NotEmpty(message = "用户名密码不为空")
    @Size(min = 1,max = 8,message = "用户名长度在1到8之间")
    private String username;
    private String password;
    private String icon;
    @Email
    private String email;
    private String nickName;
}
