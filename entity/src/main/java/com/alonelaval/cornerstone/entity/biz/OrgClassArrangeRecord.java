package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.ClassArrangeType;
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
@Table(name = "tb_org_class_arrange_record")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgClassArrangeRecord extends AbstractEntity {


    @Id
    @Column(name = "ca_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer caId;
    @Column(name = "course_id")
    private Integer courseId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "arrange_type")
    private ClassArrangeType arrangeType;
    @Column(name = "arrange_rule_name")
    private String arrangeRuleName;
    @Column(name = "class_id")
    private Integer classId;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "class_name")
    private String className;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "arrange_rule_id")
    private Integer arrangeRuleId;

    @Column(name = "employe_id")
    private Integer employeId;

    @Override
    @Transient
    protected String getEntityId() {
        return this.caId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.caId = Integer.parseInt(id);
    }
}
