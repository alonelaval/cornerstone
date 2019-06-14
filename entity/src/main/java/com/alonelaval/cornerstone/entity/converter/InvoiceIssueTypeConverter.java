package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.InvoiceIssueType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class InvoiceIssueTypeConverter implements AttributeConverter<InvoiceIssueType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(InvoiceIssueType attribute) {
        return attribute.value();
    }

    @Override
    public InvoiceIssueType convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return InvoiceIssueType.valueOf(dbData);
    }
}
