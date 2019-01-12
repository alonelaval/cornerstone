package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.CourseStartType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class CourseStartTypeConverter implements AttributeConverter<CourseStartType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(CourseStartType attribute) {
        return attribute.value();
    }

    @Override
    public CourseStartType convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return CourseStartType.valueOf(dbData);
    }
}
