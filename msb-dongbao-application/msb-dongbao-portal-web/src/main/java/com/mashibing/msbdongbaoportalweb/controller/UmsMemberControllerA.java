package com.mashibing.msbdongbaoportalweb.controller;


import com.mashibing.msbdongbaocommonbase.result.ResultWrapper;
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
        int insert = umsMemberService.insert(umsMemberREgisterParamDTO);
        return ResultWrapper.getSuccessBuilder().date(insert).build();
    }

    @PostMapping("/byName")
    public String LoginByName(@RequestBody UmsMemberLoginParamDTO umsMemberLoginParamDTO){
        String s = umsMemberService.LoginByName(umsMemberLoginParamDTO);
        return s;
    }
}

