package com.alonelaval.cornerstone.entity.model;

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
public class OrgEmployeeRecordModel implements Model {
    private String recordName;
    private LocalDate endDate;
    private LocalDate beginDate;
}
