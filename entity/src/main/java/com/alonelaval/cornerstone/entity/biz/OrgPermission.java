package com.alonelaval.cornerstone.entity.biz;

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
@Table(name = "tb_org_permission")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgPermission  extends AbstractBasePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "op_id")
    private Integer opId;
    @Column(name = "permission_id")
    private Integer permissionId;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "org_name")
    private String orgName;






    @Override
    @Transient
    protected String getEntityId() {
        return this.opId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.opId = Integer.parseInt(id);
    }
}
