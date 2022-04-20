package com.mashibing.msbdongbaoumsapi.entity.response;

import com.mashibing.msbdongbaoumsapi.entity.UmsMember;
import lombok.Data;

/**
 * @author 何水锋
 * @version 1.0
 * 少壮不努力 只有搬砖命
 * @create 2022-04-20 21:20
 */
@Data
public class UserMemberLoginResponse {

    private String token;

    private UmsMember umsMember;

}
