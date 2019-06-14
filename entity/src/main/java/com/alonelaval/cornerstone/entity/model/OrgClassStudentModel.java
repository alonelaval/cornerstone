package com.alonelaval.cornerstone.entity.model;

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
public class OrgClassStudentModel implements Model {
    /**
     * 班级ID，在调整学员或者教练的时候，使用
     */
    private Integer classId;
    /***
     * 上课的学员
     */
    private List<Integer> orgStudentIds;
}
