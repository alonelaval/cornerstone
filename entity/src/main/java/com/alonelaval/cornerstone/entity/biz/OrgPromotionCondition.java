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
@Table(name = "tb_org_promotion_condition")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgPromotionCondition extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pc_id")
    private Integer pcId;
    @Column(name = "rule_name")
    private String ruleName;
    @Column(name = "promotion_type")
    private Byte promotionType;
    @Column(name = "effect_begin_scope")
    private Integer effectBeginScope;
    @Column(name = "effect_value")
    private String effectValue;
    @Column(name = "effect_end_scope")
    private Integer effectEndScope;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "pr_id")
    private Integer prId;

    @Override
    @Transient
    protected String getEntityId() {
        return this.pcId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.pcId = Integer.parseInt(id);
    }
}
