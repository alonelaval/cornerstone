package com.alonelaval.cornerstone.entity.model;

import com.alonelaval.cornerstone.entity.constants.ClassState;
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
public class OrgClassModel implements Model {
    /**
     * 班级ID，在调整学员或者教练的时候，使用
     */
    private Integer classId;
    /**
     * 主教练ID，更换主教练时使用
     */
    private Integer mainCoachEmployeId;

    private ClassState classState;
    private Integer secondCategoryId;
    private String courseName;
    private LocalDate beginDate;
    private LocalDate endDate;
//    private State state;

}
