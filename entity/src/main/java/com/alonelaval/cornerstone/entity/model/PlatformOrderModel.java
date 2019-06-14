package com.alonelaval.cornerstone.entity.model;

import com.alonelaval.cornerstone.entity.constants.DealType;
import com.alonelaval.cornerstone.entity.constants.PayType;
import com.alonelaval.cornerstone.entity.constants.ProductVersion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author huawei
 * @create 2018-07-26
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlatformOrderModel implements Model {
    @NotNull(message = "产品版本不能为空！")
    private ProductVersion productVersion;
    @NotNull(message = "机构ID不能为空！")
    private Integer orgId;
    @NotNull(message = "机构名称不能为空！")
    private String orgName;
    @NotNull(message = "购买内容不能为空！")
    private String buyContent;
    @NotNull(message = "电话号码不能为空！")
    @NotBlank(message = "电话号码不能为空！")
    private String phone;
    @NotNull(message = "交易类型不能为空！")
    private DealType dealType;
    @NotNull(message = "金额不能为空！")
    private Integer dealAmount;
    @NotNull(message = "用户姓名不能为空！")
    @NotBlank(message = "用户姓名不能为空！")
    private String userName;
    @NotNull(message = "用户ID不能为空！")
    private Integer userId;
    private PayType payType;
    private LocalDate dealDate;
}
