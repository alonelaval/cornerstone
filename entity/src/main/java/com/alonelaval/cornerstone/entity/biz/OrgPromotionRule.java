package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author huawei
 * @create 2018-07-09
 **/
@Entity
@Table(name = "tb_org_promotion_rule")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgPromotionRule extends AbstractEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pr_id")
    private Integer prId;
    @Column(name = "effect_object")
    private Byte effectObject;
    @Column(name = "promotion_type")
    private Byte promotionType;
    @Column(name = "audit_employe_id")
    private Integer auditEmployeId;
    @Column(name = "effect_type")
    private Byte effectType;
    @Column(name = "rule_name")
    private String ruleName;
    @Column(name = "begin_date")
    private Date beginDate;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "audit_user_name")
    private String auditUserName;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "add_user_name")
    private Byte addUserName;
    @Column(name = "add_employe_id")
    private Integer addEmployeId;
    @Column(name = "add_user_id")
    private Byte addUserId;
    @Column(name = "audit_user_id")
    private Integer auditUserId;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "audit_state")
    private Byte auditState;

    @Override
    @Transient
    protected String getEntityId() {
        return this.prId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.prId = Integer.parseInt(id);
    }
}
