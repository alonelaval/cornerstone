package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.PlaceOwnType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * @author huawei
 * @create 2018-07-09
 **/
@Entity
@Table(name = "tb_org_place")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgPlace  extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private Integer placeId;
    @Column(name = "own_type")
    @Enumerated
    private PlaceOwnType ownType;
    @Column(name = "place_name")
    private String placeName;
    @Column(name = "province")
    private String province;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "end_use_date")
    private LocalDate endUseDate;
    @Column(name = "begin_use_date")
    private LocalDate beginUseDate;
    @Column(name = "address")
    private String address;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "city")
    private String city;
    @Column(name = "area")
    private Integer area;
    @Column(name = "county")
    private String county;
    @Column(name = "place_full_name")
    private String placeFullName;
    @Column(name = "x_coord")
    private String xCoord;
    @Column(name = "y_coord")
    private String yCoord;
    @Column(name = "remark")
    private String remark;

    @Transient
    List<OrgPlaceFacility> orgPlaceFacilities;

    @Override
    @Transient
    protected String getEntityId() {
        return this.placeId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.placeId = Integer.parseInt(id);
    }
}
