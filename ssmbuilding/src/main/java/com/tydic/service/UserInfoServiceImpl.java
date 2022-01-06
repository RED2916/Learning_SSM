package com.tydic.service;

import com.tydic.dao.UserInfoMapper;
import com.tydic.pojo.UserInformation;
import lombok.Setter;

import java.util.List;

public class UserInfoServiceImpl {
    @Setter
    private UserInfoMapper userInfoMapper;

    public List<UserInformation> SignInCheak(int userId, String password) {
        return userInfoMapper.SignInCheak(userId,password);
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
