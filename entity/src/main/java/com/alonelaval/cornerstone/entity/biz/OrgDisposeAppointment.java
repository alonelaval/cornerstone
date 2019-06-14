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
@Table(name = "tb_org_dispose_appointment")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgDisposeAppointment extends AbstractEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dispose_id")
    private int disposeId;

    @Column(name = "class_name")
    private String className;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "dispose_user_id")
    private Integer disposeUserId;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "course_id")
    private Integer courseId;
    @Column(name = "employe_id")
    private Integer employeId;
    @Column(name = "appointment_id")
    private Integer appointmentId;
    @Column(name = "class_id")
    private Integer classId;
    @Column(name = "dispose_user_name")
    private String disposeUserName;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "dispose_type")
    private Byte disposeType;
    @Column(name = "remark")
    private String remark;
    @Column(name = "phone")
    private String phone;
    @Column(name = "org_id")
    private Integer orgId;


    @Override
    @Transient
    protected String getEntityId() {
        return this.disposeUserId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.disposeUserId = Integer.parseInt(id);
    }
}

