package com.alonelaval.cornerstone.entity.model;

import com.alonelaval.cornerstone.entity.constants.AuditState;
import com.alonelaval.cornerstone.entity.constants.Gender;
import com.alonelaval.cornerstone.entity.constants.ProductVersion;
import com.alonelaval.cornerstone.entity.constants.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShopKeeperModel implements Model{
    private String phone;
    private String userRealName;
    private Short  age;
    private Gender gender;
    private State state;
    private ProductVersion productVersion;
    private AuditState auditState;
}
