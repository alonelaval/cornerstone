package com.alonelaval.cornerstone.entity.model;

import com.alonelaval.cornerstone.entity.constants.Gender;
import com.alonelaval.cornerstone.entity.constants.RegSource;
import com.alonelaval.cornerstone.entity.constants.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author huawei
 * @create 2018-07-23
 * 修改机构用户资料
 *
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserModel implements  Model{
    @NotNull(message = "用户ID不能为空！")
    private  Integer userId;
    private String loginName;
    private String loginPassword;
    private String phone;
    private String userName;
    private String idcard;
    private Short  age;
    private String birthDay;
    private Gender gender;
    private RegSource regSource;
    private String regTerminal;
    private String province;
    private String city;
    private String county;
    private String address;
    private String email;
    private String icon;
    private String phoneCode;
    private Integer consumeCountBegin;
    private Integer consumeCountEnd;
    private State state;

}
