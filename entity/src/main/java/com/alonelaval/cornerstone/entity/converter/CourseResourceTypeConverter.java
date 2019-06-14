package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.CourseResourceType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class CourseResourceTypeConverter implements AttributeConverter<CourseResourceType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(CourseResourceType attribute) {
        return attribute.value();
    }

    @Override
    public CourseResourceType convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return CourseResourceType.valueOf(dbData);
    }
}
