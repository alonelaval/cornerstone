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
@Table(name = "tb_org_order_promotion")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgOrderPromotion extends AbstractEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oop_id")
    private Integer oopId;
    @Column(name = "pr_id")
    private Integer prId;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "deal_number")
    private String dealNumber;
    @Column(name = "rule_name")
    private String ruleName;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "org_order_id")
    private Integer orgOrderId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "org_name")
    private String orgName;


    @Override
    @Transient
    protected String getEntityId() {
        return this.oopId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.oopId = Integer.parseInt(id);
    }
}

