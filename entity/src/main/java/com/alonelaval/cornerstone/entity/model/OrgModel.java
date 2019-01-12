package com.alonelaval.cornerstone.entity.model;

import com.alonelaval.cornerstone.entity.constants.AuditState;
import com.alonelaval.cornerstone.entity.constants.Gender;
import com.alonelaval.cornerstone.entity.constants.OrgState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.sql.Date;

/**
 * @author huawei
 * @create 2018-07-26
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrgModel implements Model {
    public static final Short DEFAULT_ORG_LEVEL = 1;
    private Integer orgId;
    @NotBlank(message = "机构名称不能为空")
    private String orgName;
    private String companyName;
    private String uscCode;
    private Integer userId;
    @NotBlank(message = "负责人不能为空")
    private String userName;
    @NotBlank(message = "负责人电话不能为空")
    private String userPhone;
    private Gender gender;
    private Integer emergencyUserId;

    private String emergencyUserName;
    private String regCapital;
    private Date establishDate;
    private String remark;
    private String iconPath;
    private Short orgLevel;
    private String phoneCode;
    private OrgState orgState;
    private AuditState auditState;
}
