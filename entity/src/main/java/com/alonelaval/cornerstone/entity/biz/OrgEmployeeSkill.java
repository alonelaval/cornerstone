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
@Table(name = "tb_org_employee_skill")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgEmployeeSkill extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oes_id")
    private Integer oesId;
    @Column(name = "second_category_id")
    private Integer secondCategoryId;
    @Column(name = "first_category_id")
    private Integer firstCategoryId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "first_category_name")
    private String firstCategoryName;
    @Column(name = "second_category_name")
    private String secondCategoryName;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "employe_id")
    private Integer employeId;

    @Override
    @Transient
    protected String getEntityId() {
        return this.oesId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.oesId = Integer.parseInt(id);
    }
}
