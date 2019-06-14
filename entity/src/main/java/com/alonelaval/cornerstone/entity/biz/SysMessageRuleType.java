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
@Table(name = "tb_org_message_rule_type")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
@Deprecated
public class SysMessageRuleType extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "omrt_id")
    private Integer omrtId;
    @Column(name = "rule_type")
    private Byte ruleType;
    @Column(name = "rule_type_name")
    private String ruleTypeName;

    @Override
    @Transient
    protected String getEntityId() {
        return this.omrtId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.omrtId = Integer.parseInt(id);
    }
}
