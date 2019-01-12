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
import java.util.List;

/**
 * @author huawei
 * @create 2018-07-09
 **/
@Entity
@Table(name = "tb_org_course")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgCourse extends AbstractEntity {

    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;
    @Column(name = "start_user_num")
    private Integer startUserNum;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "is_setting_time")
    @Enumerated
    private AllowUserSettingCourseTimeType isSettingTime;
    @Column(name = "first_category_name")
    private String firstCategoryName;
    @Column(name = "begin_date")
    private LocalDate beginDate;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "first_category_id")
    private Integer firstCategoryId;
    @Column(name = "class_type_name")
    private String classTypeName;
    @Column(name = "start_type")
    @Enumerated
    private CourseStartType startType;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "cct_id")
    private Integer cctId;
    @Column(name = "second_category_id")
    private Integer secondCategoryId;
    @Column(name = "course_type")
    @Enumerated
    private CourseType courseType;
    @Column(name = "second_category_name")
    private String secondCategoryName;
    @Column(name = "remark")
    private String remark;
    @Column(name = "org_id")
    private Integer orgId;


    @Transient
    private List<OrgCoursePeriod> periods;
    @Transient
    private Integer classTypeCount;
    @Transient
    private Integer minPrice;
    @Transient
    private Integer maxPrice;



    @Override
    @Transient
    protected String getEntityId() {
        return this.courseId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.courseId = Integer.parseInt(id);
    }
}
