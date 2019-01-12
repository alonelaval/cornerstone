package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.DayType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class DayTypeConverter implements AttributeConverter<DayType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(DayType attribute) {
        return attribute.value();
    }

    @Override
    public DayType convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return DayType.valueOf(dbData);
    }
}
