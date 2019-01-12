package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.CourseType;
import com.alonelaval.cornerstone.entity.constants.IsArrangeClass;
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
@Table(name = "tb_org_order_course")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgOrderCourse extends AbstractEntity {

    @Id
    @Column(name = "ooc_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer oocId;


    @Column(name = "total_amount")
    private Integer totalAmount;
    @Column(name = "attend_user_name")
    private String attendUserName;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "deal_number")
    private String dealNumber;
    @Column(name = "buy_course_count")
    private Integer buyCourseCount;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "course_id")
    private Integer courseId;
    @Column(name = "attend_user_id")
    private Integer attendUserId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "org_order_id")
    private Integer orgOrderId;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "org_student_id")
    private Integer orgStudentId;
    @Column(name = "user_student_id")
    private Integer userStudentId;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "course_type")
    @Enumerated
    private CourseType courseType;
    @Column(name = "buy_course_time")
    private Integer buyCourseTime;
    @Column(name = "one_course_time")
    private Integer oneCourseTime;
    @Column(name = "place_id")
    private Integer placeId;
    @Column(name = "place_name")
    private String placeName;
    @Enumerated
    @Column(name = "is_arrange_class")
    private IsArrangeClass isArrangeClass;


    @Override
    @Transient
    protected String getEntityId() {
        return this.oocId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.oocId = Integer.parseInt(id);
    }
}
