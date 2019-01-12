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
@Table(name = "tb_org_department")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgDepartment extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Integer departmentId;
    @Column(name = "department_code")
    private String departmentCode;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "org_Id")
    private Integer orgId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "parent_department_name")
    private String parentDepartmentName;
    @Column(name = "remark")
    private String remark;
    @Column(name = "department_name")
    private String departmentName;
    @Column(name = "level")
    private Short level;
    @Column(name = "parent_department_Id")
    private Integer parentDepartmentId;
    @Column(name = "employe_id")
    private Integer employeId;
    @Column(name = "org_name")
    private String orgName;


    @Override
    @Transient
    protected String getEntityId() {
        return this.departmentId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.departmentId = Integer.parseInt(id);
    }

}
