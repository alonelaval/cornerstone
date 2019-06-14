package com.alonelaval.cornerstone.entity.model;

import com.alonelaval.cornerstone.entity.constants.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @author huawei
 * @create 2018-07-26
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VmOrgCoachModel implements Model {
    private Integer employeId;

    private Integer orgId;

    private String orgName;

    private Integer userId;

    private String userName;

    private String idcard;

    private String phone;

    private String birthday;

    private String exMail;

    private LocalDate workStartDate;

    private Integer departmentId;

    private EmployeeState employeState;
    private String departmentName;

    private EduBackground eduBackground;

    private JobType jobType;

    private OrgAccountType orgAccountType;
    private String position;
    private String iconPath;
    private Gender gender;
    private IsCoach isCoach;
    private String remark;
    private State state;

    private List<Integer> secondCategoryIds;
}
