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
@Table(name = "tb_org_operation_log")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OperationLog extends AbstractEntity {

    @Id
    @Column(name = "ool_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer oolId;
    @Column(name = "employe_id")
    private Integer employeId;
    @Column(name = "operation_type")
    private Byte operationType;
    @Column(name = "operation_params")
    private String operationParams;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "operation_subject")
    private String operationSubject;
    @Column(name = "operation_subject_name")
    private String operationSubjectName;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "org_name")
    private String orgName;

    @Override
    @Transient
    protected String getEntityId() {
        return this.oolId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.oolId = Integer.parseInt(id);
    }
}
