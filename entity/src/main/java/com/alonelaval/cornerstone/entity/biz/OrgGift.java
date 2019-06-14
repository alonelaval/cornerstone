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
@Table(name = "tb_org_gift")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgGift extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gift_id")
    private Integer giftId;

    @Column(name = "add_user_id")
    private Integer addUserId;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "gift_name")
    private String giftName;
    @Column(name = "add_user_name")
    private String addUserName;
    @Column(name = "inventory")
    private Integer inventory;
    @Column(name = "add_employe_id")
    private Integer addEmployeId;


    @Override
    @Transient
    protected String getEntityId() {
        return this.giftId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.giftId = Integer.parseInt(id);
    }
}
