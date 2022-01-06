package com.tydic.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("UInf")
public class UserInformation {
    private int userId;
    private String userName;
    private String age;
    private String address;
    private String exInfo;
    private String password;
}