package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.Gender;
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
@Table(name = "tb_org_student")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgStudent extends AbstractEntity {


    @Basic
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "org_student_id")
    private Integer orgStudentId;
    @Column(name = "user_student_id")
    private Integer userStudentId;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "gender")
    @Enumerated
    private Gender gender;
    @Column(name = "guardian_user_name")
    private String guardianUserName;
    @Column(name = "guardian_user_id")
    private Integer guardianUserId;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "student_user_name")
    private String studentUserName;
    @Column(name = "current_course_num")
    private Integer currentCourseNum;
    @Column(name = "total_join_num")
    private Integer totalJoinNum;
    @Column(name = "student_user_id")
    private Integer studentUserId;
    @Column(name = "phone")
    private String phone;



    @Override
    @Transient
    protected String getEntityId() {
        return this.orgStudentId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.orgStudentId = Integer.parseInt(id);
    }
}
