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
@Entity@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
@Table(name = "tb_org_course_price")
public class OrgCoursePrice extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cp_id")
    private Integer cpId;

    @Column(name = "course_count")
    private Integer courseCount;
    @Column(name = "course_id")
    private Integer courseId;
    @Column(name = "course_time")
    private Integer courseTime;
    @Column(name = "price")
    private Integer price;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "total_course_time")
    private Integer totalCourseTime;


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
