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
@Table(name = "tb_user_attend_class_record")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class UserAttendClassRecord extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uacr_id")
    private Integer uacrId;
    @Column(name = "class_id")
    private Integer classId;
    @Column(name = "second_category_name")
    private String secondCategoryName;
    @Column(name = "end_time")
    private LocalDateTime endTime;
    @Column(name = "checkin_type")
    @Enumerated
    private CheckinType checkinType;
    @Column(name = "man_coach_user_id")
    private Integer manCoachUserId;
    @Column(name = "man_coach_employe_id")
    private Integer mainCoachEmployeId;
    @Column(name = "man_coach_user_name")
    private String manCoachUserName;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "second_category_id")
    private Integer secondCategoryId;
    @Column(name = "course_id")
    private Integer courseId;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "progress")
    private Integer progress;
    @Column(name = "class_name")
    private String className;
    @Column(name = "begin_time")
    private LocalDateTime beginTime;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "org_name")
    private String orgName;


    @Override
    @Transient
    protected String getEntityId() {
        return this.uacrId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.uacrId = Integer.parseInt(id);
    }
}
