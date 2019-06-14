package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.DealType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class DealTypeConverter implements AttributeConverter<DealType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(DealType attribute) {
        return attribute.value();
    }

    @Override
    public DealType convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return DealType.valueOf(dbData);
    }
}
