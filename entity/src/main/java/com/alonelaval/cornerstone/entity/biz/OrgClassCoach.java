package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.CoachType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author huawei
 * @create 2018-07-09
 **/
@Entity
@Table(name = "tb_org_class_coach")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgClassCoach extends AbstractEntity {

    @Id
    @Column(name = "cc_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ccId;

    @Column(name = "coach_type")
    private CoachType coachType;
    @Column(name = "class_name")
    private String className;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "class_id")
    private Integer classId;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "employe_id")
    private Integer employeId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "course_id")
    private Integer courseId;
    @Column(name = "course_name")
    private String courseName;


    @Override
    @Transient
    protected String getEntityId() {
        return this.ccId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.ccId = Integer.parseInt(id);
    }
}
