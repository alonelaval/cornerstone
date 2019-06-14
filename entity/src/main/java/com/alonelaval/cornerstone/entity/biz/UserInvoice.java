package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.InvoiceIssueType;
import com.alonelaval.cornerstone.entity.constants.InvoiceType;
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
@Table(name = "tb_user_invoice")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class UserInvoice extends AbstractEntity {
    @Basic
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private Integer invoiceId;
    @Basic
    @Column(name = "invoice_title")
    private String invoiceTitle;
    @Basic
    @Enumerated
    @Column(name = "issued_type")
    private InvoiceIssueType issuedType;
    @Basic
    @Enumerated
    @Column(name = "invoice_type")
    private InvoiceType invoiceType;
    @Basic
    @Column(name = "user_id")
    private Integer userId;

    @Basic
    @Column(name = "user_name")
    private String userName;
    @Column(name = "tax_no")
    private String taxNo;
    @Column(name = "bank_name")
    private String bankName;
    @Column(name = "back_account")
    private String bankAccount;
    @Column(name = "reg_address")
    private String regAddress;
    @Column(name = "company_phone")
    private String companyPhone;

    @Override
    @Transient
    protected String getEntityId() {
        return this.invoiceId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.invoiceId = Integer.parseInt(id);
    }
}
