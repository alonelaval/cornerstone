package com.alonelaval.cornerstone.entity.model;

import com.alonelaval.cornerstone.entity.constants.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author huawei
 * @create 2018-07-26
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VmOrgCourseModel implements Model {
    private State state;
    private String courseName;
    private LocalDate beginDate;
    private LocalDate endDate;
    private Integer secondCategoryId;
}
