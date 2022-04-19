package com.mashibing.msbdongbaoumsapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mashibing.msbdongbaoumsapi.entity.UmsMember;
import com.mashibing.msbdongbaoumsapi.entity.dto.UmsMemberLoginParamDTO;
import com.mashibing.msbdongbaoumsapi.entity.dto.UmsMemberREgisterParamDTO;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author 何水锋
 * @since 2022-04-15
 */
public interface UmsMemberService extends IService<UmsMember> {
    public int insert(UmsMemberREgisterParamDTO umsMemberREgisterParamDTO);

    public String LoginByName(UmsMemberLoginParamDTO umsMemberLoginParamDTO);
}
