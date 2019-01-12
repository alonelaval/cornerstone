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
@Table(name = "tb_org_place_resource")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgPlaceResource extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sr_id")
    private Integer srId;

    @Column(name = "place_id")
    private Integer placeId;
    @Column(name = "place_name")
    private String placeName;
    @Column(name = "resource_type")
    private Byte resourceType;
    @Column(name = "resource_path")
    private String resourcePath;


    @Override
    @Transient
    protected String getEntityId() {
        return this.srId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.srId = Integer.parseInt(id);
    }
}
