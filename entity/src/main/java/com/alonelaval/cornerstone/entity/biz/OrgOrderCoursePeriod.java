package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.DayType;
import com.alonelaval.cornerstone.entity.constants.TimeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

/**
 * @author huawei
 * @create 2018-07-09
 **/
@Entity
@Table(name = "tb_org_order_course_period")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgOrderCoursePeriod extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ocp_id")
    private Integer ocpId;

    @Column(name = "time_type")
    @Enumerated
    private TimeType timeType;
    @Column(name = "day_type")
    @Enumerated
    private DayType dayType;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "course_id")
    private Integer courseId;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "deal_number")
    private String dealNumber;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "org_order_id")
    private Integer orgOrderId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "end_time")
    private LocalTime endTime;
    @Column(name = "begin_time")
    private LocalTime beginTime;
    @Column(name = "cp_id")
    private Integer cpId;


    @Override
    @Transient
    protected String getEntityId() {
        return this.ocpId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.ocpId = Integer.parseInt(id);
    }
}
