package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.RoleCreateType;
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
@Table(name = "tb_role")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class Role extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;
    @Basic
    @Column(name = "role_name")
    private String roleName;
    @Basic
    @Column(name = "role_desc")
    private String roleDesc;
    @Column(name = "role_code")
    private String roleCode;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "org_name")
    private String orgName;
    @Basic
    @Column(name = "add_user_id")
    private Integer addUserId;
    @Basic
    @Column(name = "add_employ_id")
    private Integer addEmployId;

    @Basic
    @Column(name = "from_role_id")
    private Integer fromRoleId;

    @Basic
    @Column(name = "add_user_name")
    private String addUserName;
    @Basic
    @Column(name = "own_type")
    @Enumerated
    private RoleOwnType ownType;

    @Basic
    @Column(name = "create_type")
    @Enumerated
    private RoleCreateType createType;


    @Override
    @Transient
    protected String getEntityId() {
        return this.roleId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.roleId = Integer.parseInt(id);
    }
}
