package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.common.entity.IEnum;
import com.alonelaval.cornerstone.entity.base.IEntity;
import com.alonelaval.cornerstone.entity.constants.ClassArrangeType;
import com.alonelaval.cornerstone.entity.constants.ClassGradeType;
import com.alonelaval.cornerstone.entity.constants.ClassState;
import com.alonelaval.cornerstone.entity.constants.CourseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author huawei
 * @create 2018-07-09
 **/
@Entity
@Table(name = "tb_org_class")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor()
public class OrgClass  implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Integer classId;
    @Column(name = "class_name")
    private String className;
    @Column(name = "begin_date")
    private LocalDate beginDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "main_coach_user_id")
    private Integer mainCoachUserId;
    @Column(name = "main_coach_user_name")
    private String mainCoachUserName;
    @Column(name = "main_coach_employe_id")
    private Integer mainCoachEmployeId;
    @Column(name = "course_id")
    private Integer courseId;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "course_type")
    @Enumerated
    private CourseType courseType;

    @Column(name = "grade_type")
    @Enumerated
    private ClassGradeType gradeType;
    @Column(name = "cct_id")
    private Integer cctId;
    @Column(name = "class_type_name")
    private String classTypeName;
    @Column(name = "first_category_id")
    private Integer firstCategoryId;
    @Column(name = "first_category_name")
    private String firstCategoryName;
    @Column(name = "second_category_id")
    private Integer secondCategoryId;
    @Column(name = "second_category_name")
    private String secondCategoryName;
    @Column(name = "next_attend_date")
    private LocalDate nextAttendDate;
    @Column(name = "checkin_exponent")
    private Integer checkinExponent;
    @Column(name = "start_user_num")
    private Integer startUserNum;
    @Column(name = "join_user_num")
    private Integer joinUserNum;
    @Column(name = "arrange_type")
    @Enumerated
    private ClassArrangeType arrangeType;
    @Column(name="state")
    @Enumerated
    protected ClassState state;
    @Column(name="create_time")
    protected LocalDateTime createTime;
    @Column(name="last_update_time")
    protected LocalDateTime lastUpdateTime;
    @Column(name = "end_time")
    private LocalTime endTime;
    @Column(name = "begin_time")
    private LocalTime beginTime;
    @Column(name = "place_id")
    private Integer placeId;
    @Column(name = "place_name")
    private String placeName;



    protected String getEntityId() {
        return this.classId.toString();
    }
    protected void setEntityId(String id) {
        this.classId =Integer.parseInt(id);
    }



    @Override
    public void setState(IEnum state) {
        this.state = (ClassState) state;
    }
    @Override
    public String getId() {
        return this.classId.toString();
    }
    @Override
    public IEnum getState(){
        return  this.state;
    }

}
