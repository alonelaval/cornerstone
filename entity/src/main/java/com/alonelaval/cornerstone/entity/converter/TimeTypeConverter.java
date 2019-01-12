package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.TimeType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class TimeTypeConverter implements AttributeConverter<TimeType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(TimeType attribute) {
        return attribute.value();
    }

    @Override
    public TimeType convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return TimeType.valueOf(dbData);
    }
}
