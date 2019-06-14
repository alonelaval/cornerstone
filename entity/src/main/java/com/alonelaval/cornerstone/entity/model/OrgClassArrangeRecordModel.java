package com.alonelaval.cornerstone.entity.model;

import com.alonelaval.cornerstone.entity.constants.ClassGradeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

/**
 * @author huawei
 * @create 2018-07-26
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrgClassArrangeRecordModel implements Model {

    /**
     * 班级ID，在调整学员或者教练的时候，使用
     */
    private Integer classId;

    /**
     * 班级名称
     */
    private String className;
    /**
     * 课程
     */
    private Integer courseId;
    /***
     * 选择的教练
     */
    private List<Integer> employeIds;
    /***
     * 上课的学员
     */
    private List<Integer> orgStudentIds;

    /**
     * 开始时间
     */
    private LocalTime endTime;
    /**
     *结束时间
     */
    private LocalTime beginTime;
    /**
     * 上课时间
     */
    private Integer coursePeriodId;
    /***
     * 上课地点
     */
    private Integer coursePlaceId;
    /***
     * 班级类型
     */
    private ClassGradeType gradeType;


}
