package com.example.englishhub.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.englishhub.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author hahaha
 * @since 2023-06-09 10:14:35
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
