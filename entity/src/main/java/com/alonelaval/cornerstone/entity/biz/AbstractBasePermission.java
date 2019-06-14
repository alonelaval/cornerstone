package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.PermissionShow;
import com.alonelaval.cornerstone.entity.constants.PermissionType;
import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

/**
 * @author huawei
 * @create 2018-07-14
 **/
@MappedSuperclass
@Data
public abstract  class AbstractBasePermission extends AbstractEntity {
    @Basic
    @Column(name = "name")
    protected String name;
    @Basic
    @Column(name = "value")
    protected String value;

    @Basic
    @Enumerated
    @Column(name = "type")
    protected PermissionType type;
    @Basic
    @Column(name = "rank")
    protected Integer rank;
    @Enumerated
    @Column(name = "is_show")
    protected PermissionShow isShow;
    @Basic
    @Column(name = "parent_permission_id")
    protected Integer parentPermissionId;




}
