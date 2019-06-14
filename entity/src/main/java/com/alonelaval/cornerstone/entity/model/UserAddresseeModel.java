package com.alonelaval.cornerstone.entity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-26
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAddresseeModel implements Model {
    private String province;
    private String city;
    private String county;
    private String address;
    private String receiveUserName;
    private String receiveUserPhone;

    private List<UserAddresseeTagModel> tags;
}
