package com.mashibing.msbdongbaoums.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mashibing.msbdongbaoums.mapper.UmsMemberMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mashibing.msbdongbaoumsapi.entity.UmsMember;
import com.mashibing.msbdongbaoumsapi.entity.dto.UmsMemberLoginParamDTO;
import com.mashibing.msbdongbaoumsapi.entity.dto.UmsMemberREgisterParamDTO;
import com.mashibing.msbdongbaoumsapi.service.UmsMemberService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author 何水锋
 * @since 2022-04-15
 */
@Service
@Slf4j
public class UmsMemberServiceImpl extends ServiceImpl<UmsMemberMapper, UmsMember> implements UmsMemberService {

    @Autowired
    UmsMemberMapper umsMemberMapper;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public int insert(UmsMemberREgisterParamDTO umsMemberREgisterParamDTO) {
        UmsMember umsMember = new UmsMember();

        //通过用户名查看数据库中是否有相同的用户名
        System.out.println("11111111111111111111111111111"+umsMemberREgisterParamDTO.getUsername());
        int count = umsMemberMapper.selectOne1(umsMemberREgisterParamDTO.getUsername());
        System.out.println("11111111111111111111111111111"+count);
        if (count>0){
            log.info("有相同的用户名"+String.valueOf(count));
            return 0;
        }
        //将前端传过来的对象传给后端对象
        BeanUtils.copyProperties(umsMemberREgisterParamDTO,umsMember);
        //将前端传过来的密码进行加密
        String encode = bCryptPasswordEncoder.encode(umsMemberREgisterParamDTO.getPassword());
        //加密后传给数据库的bean
        umsMember.setPassword(encode);
        return umsMemberMapper.insert1(umsMember);
    }

    @Override
    public String LoginByName(UmsMemberLoginParamDTO umsMemberLoginParamDTO) {
        UmsMember umsMember = umsMemberMapper.selectByName(umsMemberLoginParamDTO.getUsername());
        if (null != umsMember){
            //获取数据库的密码
            String password = umsMember.getPassword();
            if (!bCryptPasswordEncoder.matches(umsMemberLoginParamDTO.getPassword(),password)){
                return "密码不正确";
            }
        }else {
            return "用户不存在";
        }
        return "登陆成功";
    }


}
