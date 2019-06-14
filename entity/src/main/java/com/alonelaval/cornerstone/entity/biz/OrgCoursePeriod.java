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
@Table(name = "tb_org_course_period")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgCoursePeriod extends AbstractEntity {
    @Id
    @Column(name = "cp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cpId;


    @Column(name = "day_type")
    private DayType dayType;
    @Column(name = "end_time")
    private LocalTime endTime;
    @Column(name = "course_id")
    private Integer courseId;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "begin_time")
    private LocalTime beginTime;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "time_type")
    @Enumerated
    private TimeType timeType;




    @Override
    @Transient
    protected String getEntityId() {
        return this.cpId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.cpId = Integer.parseInt(id);
    }
}
