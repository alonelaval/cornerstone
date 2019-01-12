package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.PlaceOwnType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author huawei
 * create by python
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vm_org_place")
public class VmOrgPlace extends AbstractEntity {
    @Column(name = "place_id")
    private Integer placeId;
    @Id
    @Column(name = "opf_id")
    private Integer opfId;

    @Column(name = "place_full_name")
    private String placeFullName;  
    @Column(name = "place_name")
    private String placeName;  
    @Column(name = "org_id")
    private Integer orgId;  
    @Column(name = "org_name")
    private String orgName;  
    @Column(name = "province")
    private String province;  
    @Column(name = "city")
    private String city;  
    @Column(name = "county")
    private String county;  
    @Column(name = "address")
    private String address;  
    @Column(name = "x_coord")
    private String xCoord;  
    @Column(name = "y_coord")
    private String yCoord;  
    @Column(name = "own_type")
    @Enumerated
    private PlaceOwnType ownType;
    @Column(name = "area")
    private Integer area;
    @Column(name = "begin_use_date")
    private LocalDate beginUseDate;  
    @Column(name = "end_use_date")
    private LocalDate endUseDate;  
    @Column(name = "remark")
    private String remark;

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