package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.CourseResourceType;
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
@Table(name = "tb_org_course_resource")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgCourseResource extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cp_id")
    private Integer cpId;

    @Column(name = "course_id")
    private Integer courseId;
    @Column(name = "resource_type")
    @Enumerated
    private CourseResourceType resourceType;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "resource_path")
    private String resourcePath;




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
