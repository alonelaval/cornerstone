package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.VisitType;
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
@Table(name = "tb_org_return_visit")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgReturnVisit extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orv_id")
    private Integer orvId;
    @Column(name = "visit_user_id")
    private Integer visitUserId;
    @Column(name = "visit_time")
    private LocalDateTime visitTime;
    @Column(name = "visit_employe_id")
    private Integer visitEmployeId;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "visit_user_name")
    private String visitUserName;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "visit_content")
    private String visitContent;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "visit_type")
    @Enumerated
    private VisitType visitType;
    @Column(name = "user_phone")
    private String userPhone;

    @Override
    @Transient
    protected String getEntityId() {
        return this.orvId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.orvId = Integer.parseInt(id);
    }
}
