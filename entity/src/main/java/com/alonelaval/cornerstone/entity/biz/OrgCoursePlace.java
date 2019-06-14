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
@Table(name = "tb_org_course_place")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgCoursePlace extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cp_id")
    private Integer cpId;

    @Column(name = "course_id")
    private Integer courseId;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "org_name")
    private  String orgName;
    @Column(name = "place_id")
    private Integer placeId;
    @Column(name = "place_name")
    private String placeName;

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
