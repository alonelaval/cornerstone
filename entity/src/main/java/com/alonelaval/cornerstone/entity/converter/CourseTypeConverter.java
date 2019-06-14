package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.CourseType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class CourseTypeConverter implements AttributeConverter<CourseType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(CourseType attribute) {
        return attribute.value();
    }

    @Override
    public CourseType convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return CourseType.valueOf(dbData);
    }
}
