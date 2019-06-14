package com.alonelaval.cornerstone.entity.model;

import com.alonelaval.cornerstone.entity.constants.DayType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

/**
 * @author huawei
 * @create 2018-07-26
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrgEmployeeWorktimeModel implements Model {
    private DayType dayType;
    private LocalTime beginTime;
    private LocalTime endTime;
    private Integer secondCategoryId;
}
