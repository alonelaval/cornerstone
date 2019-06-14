package com.alonelaval.cornerstone.entity.model;

import com.alonelaval.cornerstone.entity.constants.EduBackground;
import com.alonelaval.cornerstone.entity.constants.Gender;
import com.alonelaval.cornerstone.entity.constants.JobType;
import com.alonelaval.cornerstone.entity.constants.OrgAccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @author huawei
 * @create 2018-08-10
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoachModel implements  Model {
//    List<Integer> orgIds;

    private Integer orgId;
    private String userName;
    private String userIdcard;
    private String phone;
    private String birthday;
    private LocalDate workStartDate;
    private EduBackground eduBackground;
    private JobType jobType;
    private OrgAccountType orgAccountType;
    private String iconPath;
    private Gender gender;
    private String remark;
    private String phoneCode;


    List<OrgEmployeeRecordModel> orgEmployeeRecordModels;
    List<Integer> secondCategoryIds;
    List<OrgEmployeeWorktimeModel> orgEmployeeWorktimes;

}
