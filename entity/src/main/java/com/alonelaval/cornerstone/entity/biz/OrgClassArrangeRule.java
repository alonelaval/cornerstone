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
@Table(name = "tb_org_class_arrange_rule")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor()
public class OrgClassArrangeRule extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "arrange_rule_id")
    private Integer arrangRuleId;
    @Column(name = "arrange_rule_name")
    private String arrangRuleName;
    @Column(name = "effect_object")
    private Byte effectObject;

    @Override
    protected String getEntityId() {
        return this.arrangRuleId.toString();
    }

    @Override
    protected void setEntityId(String id) {
         this.arrangRuleId = Integer.parseInt(id);
    }
}
