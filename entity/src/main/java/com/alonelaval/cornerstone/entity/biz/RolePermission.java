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
@Table(name = "tb_role_permission")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class RolePermission extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rp_id")
    private Integer rpId;
    @Basic
    @Column(name = "role_id")
    private Integer roleId;

    @Basic
    @Column(name = "permission_id")
    private Integer permissionId;


    @Basic
    @Column(name = "op_id")
    private Integer opId;

    @Column(name = "org_id")
    private Integer orgId;

    @Column(name = "org_name")
    private String orgName;


    @Override
    @Transient
    protected String getEntityId() {
        return this.rpId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.rpId = Integer.parseInt(id);
    }
}
