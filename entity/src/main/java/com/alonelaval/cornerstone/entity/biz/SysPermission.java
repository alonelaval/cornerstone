package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.constants.PermssionOwnType;
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
@Table(name = "tb_sys_permission")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class SysPermission extends AbstractBasePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id")
    private Integer permissionId;

    @Enumerated
    @Column(name = "own_type")
    private PermssionOwnType ownType;


    @Override
    @Transient
    protected String getEntityId() {
        return this.permissionId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.permissionId = Integer.parseInt(id);
    }
}
