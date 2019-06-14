package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.DayType;
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
@Table(name = "tb_org_employee_worktime")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgEmployeeWorktime extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oew_id")
    private Integer oewId;
    @Column(name = "first_category_id")
    private Integer firstCategoryId;
    @Column(name = "day_type")
    @Enumerated
    private DayType dayType;
    @Column(name = "begin_time")
    private LocalTime beginTime;
    @Column(name = "first_category_name")
    private String firstCategoryName;
    @Column(name = "workday_id")
    private Integer workdayId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "end_time")
    private LocalTime endTime;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "second_category_id")
    private Integer secondCategoryId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "second_category_name")
    private String secondCategoryName;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "employe_id")
    private Integer employeId;



    @Override
    @Transient
    protected String getEntityId() {
        return this.oewId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.oewId = Integer.parseInt(id);
    }
}
