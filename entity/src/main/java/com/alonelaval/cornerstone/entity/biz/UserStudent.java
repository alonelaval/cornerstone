package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.Gender;
import com.alonelaval.cornerstone.entity.constants.UserRelationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author huawei
 * create by python
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_user_student")
public class UserStudent  extends AbstractEntity {
    @Basic
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_student_id")
    private Integer userStudentId;
    @Column(name = "guardian_user_id")
    private Integer guardianUserId;  
    @Column(name = "guardian_user_name")
    private String guardianUserName;  
    @Column(name = "student_user_id")
    private Integer studentUserId;  
    @Column(name = "student_user_name")
    private String studentUserName;  
    @Column(name = "total_join_num")
    private Integer totalJoinNum;  
    @Column(name = "current_course_num")
    private Integer currentCourseNum;
    @Column(name = "gender")
    @Enumerated
    private Gender gender;
    @Column(name="phone")
    private String phone;
    @Column(name="birthday")
    private String birthday;
    @Column(name = "relation_type")
    @Enumerated
    private UserRelationType relationType;

    @Override
    @Transient
    protected String getEntityId() {
        return this.userStudentId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.userStudentId = Integer.parseInt(id);
    }
}