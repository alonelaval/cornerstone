package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author huawei
 * create by python
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_org_place_facility")
public class OrgPlaceFacility extends AbstractEntity {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "opf_id")
    private Integer opfId;  
    @Column(name = "facility_id")
    private Integer facilityId;  
    @Column(name = "facility_name")
    private String facilityName;  
    @Column(name = "first_category_id")
    private Integer firstCategoryId;  
    @Column(name = "first_category_name")
    private String firstCategoryName;  
    @Column(name = "second_category_id")
    private Integer secondCategoryId;  
    @Column(name = "second_category_name")
    private String secondCategoryName;  
    @Column(name = "place_id")
    private Integer placeId;  
    @Column(name = "place_name")
    private String placeName;  
    @Column(name = "org_id")
    private Integer orgId;  
    @Column(name = "org_name")
    private String orgName;


    @Override
    @Transient
    protected String getEntityId() {
        return this.opfId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.opfId = Integer.parseInt(id);
    }
}