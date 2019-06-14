package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.ClassArrangeType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class ClassArrangeTypeConverter implements AttributeConverter<ClassArrangeType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(ClassArrangeType attribute) {
        return attribute.value();
    }

    @Override
    public ClassArrangeType convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return ClassArrangeType.valueOf(dbData);
    }
}
