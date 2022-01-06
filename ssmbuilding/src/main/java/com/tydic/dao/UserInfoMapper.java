package com.tydic.dao;

import com.tydic.pojo.UserInformation;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserInfoMapper {
    @Select("select * from mybatislearning.userinformation where userId=#{userId} and password=#{password}")
    public List<UserInformation> SignInCheak(@Param("userId") int userId, @Param("password") String password);
}
