package com.alonelaval.cornerstone.entity.model;

import com.alonelaval.cornerstone.entity.constants.State;
import com.alonelaval.cornerstone.entity.constants.VisitType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author huawei
 * @create 2018-07-26
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrgReturnVisitModel implements Model {

    private Integer visitUserId;
    private LocalDateTime visitTime;
    private Integer visitEmployeId;
    private Integer orgId;
    private String visitUserName;
    private String orgName;
    private Integer userId;
    private String visitContent;
    private String userName;
    private VisitType visitType;
    private String userPhone;
    private State state;
    private LocalDateTime beginVisitTime;
    private LocalDateTime endVisitTime;
}
