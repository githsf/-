package com.mashibing.msbdongbaoums.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mashibing.msbdongbaoumsapi.entity.UmsMember;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 后台用户表 Mapper 接口
 * </p>
 *
 * @author 何水锋
 * @since 2022-04-15
 */
@Repository
public interface UmsMemberMapper extends BaseMapper<UmsMember> {
    int insert1(UmsMember umsMember);

    int selectOne1(String username);

   UmsMember selectByName(String username);
}
