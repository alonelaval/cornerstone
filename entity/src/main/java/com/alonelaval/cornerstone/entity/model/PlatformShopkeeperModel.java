package com.alonelaval.cornerstone.entity.model;

import com.alonelaval.cornerstone.entity.constants.AuditState;
import com.alonelaval.cornerstone.entity.constants.ProductVersion;
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
public class PlatformShopkeeperModel implements Model {

    private Integer userId;

    private String userName;

    private String phone;

    private ProductVersion productVersion;

    private Integer addUserId;

    private String addUserName;

    protected LocalDate effectBeginDate;

    protected LocalDate effectEndDate;

    private Short durationMonth;

    private AuditState auditState;

    private Short orgCount;

    private Integer orgId;

    private String orgName;

    private Integer employeId;

    private State state;
}
