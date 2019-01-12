package com.alonelaval.cornerstone.entity.model;

import com.alonelaval.cornerstone.entity.constants.OrderState;
import com.alonelaval.cornerstone.entity.constants.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author huawei
 * @create 2018-07-26
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrgOrderModel implements Model {

    /** 被下单的机构 */
    private Integer orgId;
    /**购买的课程*/
    private Integer courseId;
    /**
     *用户选择的学生
     */
    private Integer userStudentId;
    /**选择的教练*/
    private Integer employeId;
    /**价格*/
    private Integer coursePriceId;
    /**
     * 选择上课地点
     */
    private Integer coursePlaceId;
    /**
     * 下单的用户，如果没有传，代表下单的用户是C端用户
     */
    private Integer userId;

    /**
     * 选择上课的周期
     */
    private List<Integer> coursePeriodIds;
    /**
     * 备注
     */
    private String remark;

    /**
     * 订单编号
     */
    private String dealNumber;

    // for query

    private String userName;
    private State state;
    private OrderState orderState;
    private Integer maxAmount;
    private Integer minAmount;
    private LocalDateTime beginOrderDate;
    private LocalDateTime endOrderDate;


}
