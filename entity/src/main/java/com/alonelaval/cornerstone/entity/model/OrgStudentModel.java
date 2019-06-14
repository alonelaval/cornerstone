package com.alonelaval.cornerstone.entity.model;

import com.alonelaval.cornerstone.entity.constants.Gender;
import com.alonelaval.cornerstone.entity.constants.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huawei
 * @create 2018-07-26
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrgStudentModel implements Model {
    private Integer studentId;
    private Integer orgId;
    private Gender gender;
    private String orgName;
    private String studentUserName;
    private Integer studentUserId;
    private String phone;
    private String guardianUserName;
    private Integer guardianUserId;
    private State state;
}
