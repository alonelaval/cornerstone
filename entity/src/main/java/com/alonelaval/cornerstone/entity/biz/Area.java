package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.AdminDivision;
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
@Table(name = "tb_area")
public class Area extends AbstractEntity {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "area_id")
    private Integer areaId;  
    @Column(name = "area_name")
    private String areaName;
    @Column(name = "level")
    private Byte level;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "area_code")
    private String areaCode;
    @Column(name = "parent_area_id")
    private Integer parentAreaId;
    @Column(name = "parent_area_name")
    private String parentAreaName;
    @Column(name = "admin_division")
    @Enumerated
    private AdminDivision adminDivision;


    @Override
    @Transient
    protected String getEntityId() {
        return this.areaId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.areaId = Integer.parseInt(id);
    }

}