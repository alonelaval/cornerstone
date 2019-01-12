package com.alonelaval.cornerstone.entity.model;

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
public class RolePermissionModel implements Model {
    private Integer permissionId;
    private Integer opId;
}
