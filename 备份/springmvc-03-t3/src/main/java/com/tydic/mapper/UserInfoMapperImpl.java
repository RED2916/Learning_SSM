package com.tydic.mapper;

import com.tydic.pojo.UserInformation;
import lombok.Setter;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.util.List;

public class UserInfoMapperImpl implements UserInfoMapper{
    @Setter
    private SqlSession sqlSession;


    public List<UserInformation> SignInCheak(int userId, String password) {
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
        return mapper.SignInCheak(userId,password);
    }

    //0登录成功，1则失败
    public int getSingInCheck(int userId, String password){
        List<UserInformation> userInformations = this.SignInCheak(userId,password);
        if (userInformations == null || userInformations.isEmpty()){
            return 1;
        }else {
            return 0;
        }
    }
}
