package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.CheckinType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author huawei
 * @create 2018-07-09
 **/
@Entity
@Table(name = "tb_org_employee_checkin")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgEmployeeCheckin extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oec_id")
    private Integer oecId;
    @Column(name = "end_time")
    private LocalDateTime endTime;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "class_id")
    private Integer classId;
    @Column(name = "second_category_name")
    private String secondCategoryName;
    @Column(name = "class_name")
    private String className;
    @Column(name = "employe_id")
    private Integer employeId;
    @Column(name = "begin_time")
    private LocalDateTime beginTime;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "second_category_Id")
    private Integer secondCategoryId;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "course_id")
    private Integer courseId;
    @Column(name = "checkin_type")
    @Enumerated
    private CheckinType checkinType;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "progress")
    private Integer progress;



    @Override
    @Transient
    protected String getEntityId() {
        return this.oecId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.oecId = Integer.parseInt(id);
    }
}

