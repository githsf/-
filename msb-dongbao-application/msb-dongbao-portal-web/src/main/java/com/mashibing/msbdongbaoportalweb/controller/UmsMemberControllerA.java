package com.mashibing.msbdongbaoportalweb.controller;


import com.mashibing.msbdongbaocommonbase.annotation.TokenCheck;
import com.mashibing.msbdongbaocommonbase.result.ResultWrapper;
import com.mashibing.msbdongbaocommonutil.JWTUtil;
import com.mashibing.msbdongbaoumsapi.entity.UmsMember;
import com.mashibing.msbdongbaoumsapi.entity.dto.UmsMemberLoginParamDTO;
import com.mashibing.msbdongbaoumsapi.entity.dto.UmsMemberREgisterParamDTO;
import com.mashibing.msbdongbaoumsapi.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author 何水锋
 * @since 2022-04-15
 */
@RestController
@RequestMapping("/ums-member")
public class UmsMemberControllerA {
    @Autowired
    UmsMemberService umsMemberService;
    @PostMapping ("/in")
    public ResultWrapper inserts(@RequestBody @Valid UmsMemberREgisterParamDTO umsMemberREgisterParamDTO){
        System.out.println("11111111111111111111111:"+umsMemberREgisterParamDTO.toString());
        return umsMemberService.insert(umsMemberREgisterParamDTO);
    }

    @PostMapping("/byName")
    public ResultWrapper LoginByName(@RequestBody UmsMemberLoginParamDTO umsMemberLoginParamDTO){
        return umsMemberService.LoginByName(umsMemberLoginParamDTO);
    }

    @PostMapping("/edit")
    @TokenCheck
    public ResultWrapper LoginByName(@RequestBody  UmsMember umsMember){
       return umsMemberService.edit(umsMember);
    }

    //测试token
    @GetMapping("/test-token")
    public String LoginByName(String token){
        String token1 = JWTUtil.parseToken(token);
        return token1;
    }
}

