package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.InvoiceType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class InvoiceTypeConverter implements AttributeConverter<InvoiceType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(InvoiceType attribute) {
        return attribute.value();
    }

    @Override
    public InvoiceType convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return InvoiceType.valueOf(dbData);
    }
}
