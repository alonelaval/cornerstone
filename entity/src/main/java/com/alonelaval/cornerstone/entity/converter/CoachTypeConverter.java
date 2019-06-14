package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.CoachType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class CoachTypeConverter implements AttributeConverter<CoachType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(CoachType attribute) {
        return attribute.value();
    }

    @Override
    public CoachType convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return CoachType.valueOf(dbData);
    }
}
