package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.OrderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author huawei
 * create by python
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_order_invoice_record")
public class OrderInvoiceRecord extends AbstractEntity {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "oir_id")
    private Integer oirId;  
    @Column(name = "org_id")
    private Integer orgId;  
    @Column(name = "org_name")
    private String orgName;  
    @Column(name = "user_id")
    private Integer userId;  
    @Column(name = "user_name")
    private String userName;  
    @Column(name = "invoice_id")
    private Integer invoiceId;  
    @Column(name = "invoice_title")
    private String invoiceTitle;  
    @Column(name = "invoice_code")
    private String invoiceCode;  
    @Column(name = "addresseeId")
    private Integer addresseeId;  
    @Column(name = "receive_user_name")
    private String receiveUserName;  
    @Column(name = "receive_user_phone")
    private String receiveUserPhone;  
    @Column(name = "order_type")
    private OrderType orderType;




    @Override
    protected String getEntityId() {
        return this.oirId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.oirId = Integer.parseInt(id);
    }
}