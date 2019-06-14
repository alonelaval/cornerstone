package com.alonelaval.cornerstone.entity.model;

import com.alonelaval.cornerstone.entity.constants.PlaceOwnType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @author huawei
 * @create 2018-07-26
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrgPlaceModel implements Model {
    private PlaceOwnType ownType;
    private String placeName;
    private String province;
    private LocalDate endUseDate;
    private LocalDate beginUseDate;
    private String address;
    private String city;
    private Integer area;
    private String county;
    private String placeFullName;
    private String xCoord;
    private String yCoord;
    private List<Integer> facilityIds;
    private String remark;
 }
