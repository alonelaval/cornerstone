package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * @author huawei
 * @create 2018-07-09
 **/
@Entity
@Table(name = "tb_org_employee")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()

public class OrgEmployee extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employe_id")
    private Integer employeId;
    @Basic
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "user_name")
    private String userName;
    @Basic
    @Column(name = "idcard")
    private String idcard;
    @Basic
    @Column(name = "phone")
    private String phone;

    @Basic
    @Column(name = "birthday")
    private String birthday;
    @Basic
    @Column(name = "ex_mail")
    private String exMail;
    @Basic
    @Column(name = "work_start_date")
    private LocalDate workStartDate;
    @Basic
    @Column(name = "department_id")
    private Integer departmentId;
    @Column(name="gender")
    @Enumerated()
    private Gender gender;
    @Basic
    @Column(name = "department_name")
    private String departmentName;
    @Column(name="employe_state")
    @Enumerated
    private EmployeeState employeState;
    @Basic
    @Enumerated
    @Column(name = "edu_background")
    private EduBackground eduBackground;
    @Basic
    @Enumerated
    @Column(name = "job_type")
    private JobType jobType;

    @Column(name = "org_account_type")
    @Enumerated
    private OrgAccountType orgAccountType;
    @Column(name = "position")
    private String position;

    @Column(name = "is_coach")
    @Enumerated
    private IsCoach isCoach;
    @Column(name="icon")
    private String icon;
    @Column(name="remark")
    private String remark;


    @Transient
    private List<OrgEmployeeWorkday> workdays;

    @Transient
    private List<OrgEmployeeSkill> skills;


    @Override
    @Transient
    protected String getEntityId() {
        return this.employeId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.employeId = Integer.parseInt(id);
    }
}

