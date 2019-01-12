package com.alonelaval.cornerstone.entity.model;

import com.alonelaval.cornerstone.entity.constants.InvoiceIssueType;
import com.alonelaval.cornerstone.entity.constants.InvoiceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

/**
 * @author huawei
 * @create 2018-07-29
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceModel implements  Model{



    private String invoiceTitle;
    @NotNull
    private InvoiceIssueType issuedType;
    @NotNull
    private InvoiceType invoiceType;

    private String userName;

    private String taxNo;

    private String bankName;

    private String bankAccount;

    private String regAddress;

    private String companyPhone;


    @AssertTrue(message="参数错误！")
    private boolean isValid() {
        if(InvoiceIssueType.COMPANY == issuedType){
            if(StringUtils.isBlank(invoiceTitle)){
                return  false;
            }
        }
        return  true;
    }
}
