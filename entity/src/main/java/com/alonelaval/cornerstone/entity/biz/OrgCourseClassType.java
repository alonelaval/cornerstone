package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.CourseStartType;
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
@Table(name = "tb_org_course_class_type")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgCourseClassType extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cct_id")
    private Integer cctId;


    @Column(name = "start_user_num")
    private Integer startUserNum;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "start_type")
    @Enumerated
    private CourseStartType startType;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "class_type_name")
    private String classTypeName;


    @Override
    @Transient
    protected String getEntityId() {
        return this.cctId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.cctId = Integer.parseInt(id);
    }
}
