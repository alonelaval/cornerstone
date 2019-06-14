package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.IsInvoiced;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class IsInvoicedConverter implements AttributeConverter<IsInvoiced, Integer> {
    @Override
    public Integer convertToDatabaseColumn(IsInvoiced attribute) {
        return attribute.value();
    }

    @Override
    public IsInvoiced convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return IsInvoiced.valueOf(dbData);
    }
}
