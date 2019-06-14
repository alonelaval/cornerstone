package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.IsCoach;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class IsCoachConverter implements AttributeConverter<IsCoach, Integer> {
    @Override
    public Integer convertToDatabaseColumn(IsCoach attribute) {
        return attribute.value();
    }

    @Override
    public IsCoach convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return IsCoach.valueOf(dbData);
    }
}
