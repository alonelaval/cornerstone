package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author huawei
 * @create 2018-07-09
 **/
@Entity
@Table(name = "tb_platform_order")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class PlatformOrder extends AbstractEntity {
    @Basic
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name="effect_begin_date")
    protected LocalDate effectBeginDate;
    @Column(name="effect_end_date")
    protected LocalDate effectEndDate;
    @Enumerated
    @Column(name = "product_version")
    private ProductVersion productVersion;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "buy_content")
    private String buyContent;
    @Column(name = "is_invoiced")
    @Enumerated
    private IsInvoiced isInvoiced;
    @Column(name = "add_user_name")
    private String addUserName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "add_user_id")
    private Integer addUserId;
    @Column(name = "deal_type")
    @Enumerated
    private DealType dealType;
    @Column(name = "deal_date")
    private LocalDate dealDate;
    @Column(name = "deal_amount")
    private Integer dealAmount;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "deal_number")
    private String dealNumber;
    @Column(name = "pay_type")
    @Enumerated
    private PayType payType;
    @Enumerated
    @Column(name = "order_state")
    private OrderState orderState;
//    @Column(name = "oir_id")
//    private Integer oirId;


    @Override
    @Transient
    protected String getEntityId() {
        return this.orderId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.orderId = Integer.parseInt(id);
    }
}
