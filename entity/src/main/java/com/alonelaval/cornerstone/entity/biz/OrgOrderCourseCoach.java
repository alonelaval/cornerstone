package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
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
@Table(name = "tb_org_order_course_coach")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgOrderCourseCoach  extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oocc_id")
    private Integer ooccId;
    @Column(name = "employe_id")
    private Integer employeId;
    @Column(name = "org_order_id")
    private Integer orgOrderId;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "coach_user_name")
    private String coachUserName;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "coach_user_id")
    private Integer coachUserId;
    @Column(name = "deal_number")
    private String dealNumber;
    @Column(name = "course_id")
    private Integer courseId;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "org_name")
    private String orgName;

    @Override
    @Transient
    protected String getEntityId() {
        return this.ooccId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.ooccId = Integer.parseInt(id);
    }

}
