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
public class OrgEmployeeCheckinModel implements Model {
    /**
     * 签到的班级
     */
    private Integer classId;
    /***
     * 签到的员工
     */
    private Integer employeId;

    /**
     * 签到方式
     */
    private CheckinType checkinType;

}
