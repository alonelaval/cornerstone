package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.DayType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author huawei
 * @create 2018-07-09
 **/
@Entity
@Table(name = "tb_org_employee_workday")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgEmployeeWorkday extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workday_id")
    private Integer workdayId;

    @Column(name = "user_name")
    private String userName;
//    @Column(name = "second_category_name")
//    private String secondCategoryName;
    @Column(name = "employe_id")
    private Integer employeId;
//    @Column(name = "first_category_name")
//    private String firstCategoryName;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "day_type")
    @Enumerated
    private DayType dayType;
//    @Column(name = "second_category_id")
//    private Integer secondCategoryId;
//    @Column(name = "first_category_id")
//    private Integer firstCategoryId;
    @Column(name = "org_name")
    private String orgName;


    @Transient
    List<OrgEmployeeWorktime> orgEmployeeWorktimes;

    @Override
    @Transient
    protected String getEntityId() {
        return this.workdayId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.workdayId = Integer.parseInt(id);
    }
}
