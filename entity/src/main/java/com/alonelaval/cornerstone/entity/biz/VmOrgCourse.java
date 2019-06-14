package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.AllowUserSettingCourseTimeType;
import com.alonelaval.cornerstone.entity.constants.CourseStartType;
import com.alonelaval.cornerstone.entity.constants.CourseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author huawei
 * create by python
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vm_org_course")
public class VmOrgCourse  extends AbstractEntity {

    @Column(name = "course_id")
    private Integer courseId;  
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "course_type")
    @Enumerated
    private CourseType courseType;
    @Column(name = "first_category_id")
    private Integer firstCategoryId;  
    @Column(name = "first_category_name")
    private String firstCategoryName;  
    @Column(name = "second_category_id")
    private Integer secondCategoryId;  
    @Column(name = "second_category_name")
    private String secondCategoryName;  
    @Column(name = "cct_id")
    private Integer cctId;  
    @Column(name = "class_type_name")
    private String classTypeName;
    @Column(name = "start_type")
    @Enumerated
    private CourseStartType startType;
    @Column(name = "begin_date")
    private LocalDate beginDate;  
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "is_setting_time")
    @Enumerated
    private AllowUserSettingCourseTimeType isSettingTime;
    @Column(name = "start_user_num")
    private Integer startUserNum;  
    @Column(name = "org_id")
    private Integer orgId;  
    @Column(name = "org_name")
    private String orgName;  
    @Column(name = "remark")
    private String remark;
    @Column(name = "price")
    private Integer price;
    @Id
    @Column(name = "cp_id")
    private Integer cpId;  
    @Column(name = "course_time")
    private Integer courseTime;  
    @Column(name = "total_course_time")
    private Integer totalCourseTime;  
    @Column(name = "course_count")
    private Integer courseCount;

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