package com.alonelaval.cornerstone.entity.model;

import com.alonelaval.cornerstone.entity.constants.Gender;
import com.alonelaval.cornerstone.entity.constants.State;
import com.alonelaval.cornerstone.entity.constants.UserRelationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huawei
 * @create 2018-08-13
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserStudentModel implements Model {
    private String studentUserName;
    private Gender gender;
    private String phone;
    private String birthday;
    private UserRelationType relationType;
    private String phoneCode;
    private State state;
    private String guardianUserName;
    private Integer guardianUserId;
}
