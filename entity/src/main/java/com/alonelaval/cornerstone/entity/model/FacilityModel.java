package com.alonelaval.cornerstone.entity.model;

import com.alonelaval.cornerstone.entity.constants.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-26
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FacilityModel implements Model {
    /**
     * 设施名称
     */
    private String facilityName;
    /**
     * 课程科目
     */
    private Integer secondCategoryId;

    private State state;

    private List<Integer> secondCategoryIds;
}
