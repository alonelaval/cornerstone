package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.RoleOwnType;
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
@Table(name = "tb_user_role")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class UserRole extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ur_id")
    private Integer urId;
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @Basic
    @Column(name = "role_Id")
    private Integer roleId;
    @Basic
    @Column(name = "org_id")
    private Integer orgId;
    @Basic
    @Column(name = "org_name")
    private String orgName;
    @Basic
    @Column(name = "own_type")
    @Enumerated
    private RoleOwnType ownType;

    @Override
    @Transient
    protected String getEntityId() {
        return this.urId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.urId = Integer.parseInt(id);
    }
}
