package com.alonelaval.cornerstone.entity.model;

import com.alonelaval.cornerstone.entity.constants.CheckinType;
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
public class UserAttendClassRecordModel implements Model {

    /**
     * 班级ID
     */
    private Integer classId;
    /**
     * 课程Id
     */
    private Integer courseId;
    /**
     * 主教练
     */
    private Integer mainCoachEmployeId;

    /**
     *用户ID
     */
    private Integer userId;
    /**
     * 签到类型
     */
    private CheckinType checkinType;
}
