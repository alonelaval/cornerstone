package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;  

/**
 * @author huawei
 * create by python
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vm_org_coach")
public class VmOrgCoach extends AbstractEntity {

    @Column(name = "org_id")
    private Integer orgId;  
    @Column(name = "org_name")
    private String orgName;  
    @Column(name = "user_id")
    private Integer userId;  
    @Column(name = "user_name")
    private String userName;  
    @Column(name = "phone")
    private String phone;  
    @Column(name = "work_start_date")
    private LocalDate workStartDate;
    @Column(name="gender")
    @Enumerated()
    private Gender gender;

    @Column(name = "create_time")
    private LocalDateTime createTime;  
    @Column(name = "second_category_id")
    private Integer secondCategoryId;  
    @Column(name = "second_category_name")
    private String secondCategoryName;  
    @Column(name = "first_category_id")
    private Integer firstCategoryId;  
    @Column(name = "first_category_name")
    private String firstCategoryName;  



    @Column(name = "department_name")
    private String departmentName;  
    @Column(name = "department_id")
    private Integer departmentId;  
    @Column(name = "ex_mail")
    private String exMail;  
    @Column(name = "birthday")
    private String birthday;  
    @Column(name = "idcard")
    private String idcard;  

    @Column(name = "position")
    private String position;  

    @Column(name = "icon")
    private String icon;  
    @Column(name = "remark")
    private String remark;  
    @Column(name = "last_update_time")
    private LocalDateTime lastUpdateTime;

    @Column(name = "employe_id")
    private Integer employeId;
    @Id
    @Column(name = "oes_id")
    private Integer oesId;


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

    @Column(name = "is_coach")
    @Enumerated
    private IsCoach isCoach;


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