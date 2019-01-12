package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.IsInvoiced;
import com.alonelaval.cornerstone.entity.constants.OrderState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author huawei
 * @create 2018-07-09
 **/
@Entity
@Table(name = "tb_org_order" )
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgOrder extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "org_order_id")
    private Integer orgOrderId;

    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "deal_number")
    private String dealNumber;
    @Column(name = "sell_user_id")
    private Integer sellUserId;
    @Column(name = "is_invoiced")
    @Enumerated
    private IsInvoiced isInvoiced;
    @Column(name = "sell_user_name")
    private String sellUserName;
    @Column(name = "total_pay_amount")
    private Integer totalPayAmount;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "phone")
    private String phone;
    @Column(name = "remark")
    private String remark;
    @Column(name = "sell_employe_id")
    private Integer sellEmployeId;
    @Column(name = "user_name")
    private String userName;

    @Column(name = "order_time")
    private LocalDateTime orderTime;

    @Enumerated
    @Column(name = "order_state")
    private OrderState orderState;
    @Column(name = "oir_id")
    private Integer oirId;
    @Column(name = "refund_amount")
    private Integer refundAmount;



    @Override
    @Transient
    protected String getEntityId() {
        return this.orgOrderId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.orgOrderId = Integer.parseInt(id);
    }
}
