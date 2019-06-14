package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
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
@Table(name = "tb_org_employee_record")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgEmployeeRecord extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Integer recordId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "record_name")
    private String recordName;
    @Column(name = "employe_id")
    private Integer employeId;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "begin_date")
    private LocalDate beginDate;


    @Override
    @Transient
    protected String getEntityId() {
        return this.recordId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.recordId = Integer.parseInt(id);
    }

}
