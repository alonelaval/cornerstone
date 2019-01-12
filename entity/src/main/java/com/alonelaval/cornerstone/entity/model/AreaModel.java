package com.alonelaval.cornerstone.entity.model;

import com.alonelaval.cornerstone.entity.constants.AdminDivision;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huawei
 * @create 2018-07-26
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AreaModel implements Model {
    private String areaName;
    private String zipCode;
    private Integer parentAreaId;
    private String parentAreaName;
    /***
     * 行政划分
     */
    private AdminDivision adminDivision;
}
