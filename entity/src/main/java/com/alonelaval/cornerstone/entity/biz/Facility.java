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
@Table(name = "tb_facility")
public class Facility extends AbstractEntity {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
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
        return this.facilityId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.facilityId = Integer.parseInt(id);
    }
	
}