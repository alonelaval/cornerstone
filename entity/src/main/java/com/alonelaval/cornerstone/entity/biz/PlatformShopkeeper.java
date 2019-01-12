package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.AuditState;
import com.alonelaval.cornerstone.entity.constants.ProductVersion;
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
@Table(name = "tb_platform_shopkeeper")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class PlatformShopkeeper extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ps_id")
    private Integer psId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "product_version")
    private ProductVersion productVersion;
    @Column(name = "add_user_id")
    private Integer addUserId;
    @Column(name = "add_user_name")
    private String addUserName;
    @Column(name="effect_begin_date")
    protected LocalDate effectBeginDate;
    @Column(name="effect_end_date")
    protected LocalDate effectEndDate;
    @Column(name="duration_month")
    private Short durationMonth;
    @Column(name="audit_state")
    @Enumerated
    private AuditState auditState;
    @Column(name="org_count")
    private Short orgCount;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "employe_id")
    private Integer employeId;


    @Override
    @Transient
    protected String getEntityId() {
        return this.psId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.psId = Integer.parseInt(id);
    }
}
