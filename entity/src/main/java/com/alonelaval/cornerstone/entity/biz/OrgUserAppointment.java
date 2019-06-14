package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author huawei
 * @create 2018-07-09
 **/
@Entity
@Table(name = "tb_org_user_appointment")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgUserAppointment extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Integer appointmentId;


    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "course_id")
    private Integer courseId;
    @Column(name = "class_id")
    private Integer classId;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "phone")
    private String phone;
    @Column(name = "appointment_date")
    private Timestamp appointmentDate;
    @Column(name = "class_name")
    private String className;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "org_name")
    private String orgName;

    @Override
    @Transient
    protected String getEntityId() {
        return this.appointmentId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.appointmentId = Integer.parseInt(id);
    }
}
