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
@Entity
@Table(name = "tb_org_class_student")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgClassStudent extends AbstractEntity {
    @Id
    @Column(name = "sc_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer scId;
    @Column(name = "class_name")
    private String className;
    @Column(name = "org_student_id")
    private Integer orgStudentId;
    @Column(name = "user_student_id")
    private Integer userStudentId;
    @Column(name = "student_user_id")
    private Integer studentUserId;
    @Column(name = "course_id")
    private Integer courseId;
    @Column(name = "student_user_name")
    private String studentUserName;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "class_id")
    private Integer classId;
    @Column(name = "org_name")
    private String orgName;

    @Override
    @Transient
    protected String getEntityId() {
        return this.scId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.scId = Integer.parseInt(id);
    }
}
