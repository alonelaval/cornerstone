package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.OrgResourceType;
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
@Table(name = "tb_org_resource")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgResource extends AbstractEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resource_id")
    private Integer resourceId;

    @Column(name = "resource_type")
    private OrgResourceType resourceType;
    @Column(name = "resource_name")
    private String resourceName;
    @Column(name = "resource_path")
    private String resourcePath;
    @Column(name = "org_id")
    private Integer orgId;

    @Override
    @Transient
    protected String getEntityId() {
        return this.resourceId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.resourceId = Integer.parseInt(id);
    }
}
