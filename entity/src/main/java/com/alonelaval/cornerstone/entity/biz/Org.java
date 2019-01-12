package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.common.entity.IEnum;
import com.alonelaval.cornerstone.entity.base.IEntity;
import com.alonelaval.cornerstone.entity.constants.AuditState;
import com.alonelaval.cornerstone.entity.constants.OrgState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author huawei
 * @create 2018-07-09
 **/
@Entity
@Table(name = "tb_org")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Org implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "usc_code")
    private String uscCode;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_phone")
    private String userPhone;
    @Column(name = "emergency_user_id")
    private Integer emergencyUserId;
    @Column(name = "emergency_user_name")
    private String emergencyUserName;
    @Column(name = "reg_capital")
    private String regCapital;
    @Column(name = "establish_date")
    private Date establishDate;
    @Column(name = "remark")
    private String remark;
    @Column(name="audit_state")
    @Enumerated
    private AuditState auditState;
    @Column(name = "parent_org_id")
    private Integer parentOrgId;
    @Column(name = "parent_org_name")
    private String parentOrgName;
    @Column(name = "org_code")
    private String orgCode;
    @Column(name = "org_level")
    private Short orgLevel;
    @Column(name = "state")
    protected OrgState state;
    @Column(name="create_time")
    protected LocalDateTime createTime;
    @Column(name="last_update_time")
    protected LocalDateTime lastUpdateTime;
    @Column(name="icon")
    private String icon;



    @Override
    public void setState(IEnum state) {
        this.state = (OrgState) state;
    }

    @Override
    public String getId() {
        return this.orgId.toString();
    }

    @Override
    public IEnum getState(){
        return  this.state;
    }



    @Transient
    private List<OrgResource> orgResources;

    protected String getEntityId() {
        return this.orgId.toString();
    }

    protected void setEntityId(String id) {
        this.orgId = Integer.parseInt(id);
    }


}
