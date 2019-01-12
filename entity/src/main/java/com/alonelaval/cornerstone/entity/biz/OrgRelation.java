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
 * @deprecated 废弃
 **/
@Entity
@Table(name = "tb_org_relation")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
@Deprecated
public class OrgRelation extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "or_id")
    private Integer orId;
    @Column(name = "sub_org_id")
    private Integer subOrgId;
    @Column(name = "relation_type")
    private Byte relationType;
    @Column(name = "sub_org_name")
    private String subOrgName;
    @Column(name = "parent_org_id")
    private Integer parentOrgId;
    @Column(name = "parent_org_name")
    private String parentOrgName;
    @Column(name = "org_code")
    private String orgCode;
    @Column(name = "org_level")
    private Integer orgLevel;


    @Override
    @Transient
    protected String getEntityId() {
        return this.orId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.orId = Integer.parseInt(id);
    }
}
