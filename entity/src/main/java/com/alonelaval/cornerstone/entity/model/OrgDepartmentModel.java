package com.alonelaval.cornerstone.entity.model;

import com.alonelaval.cornerstone.entity.constants.State;
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
public class OrgDepartmentModel implements Model {
    private String remark;
    private String departmentName;
    private Integer parentDepartmentId;
    private String parentDepartmentName;
    /**
     * 部门负责人
     */
    private Integer employeId;

    //for query

    private State state;
    private String departmentCode;
    private Integer orgId;

}
