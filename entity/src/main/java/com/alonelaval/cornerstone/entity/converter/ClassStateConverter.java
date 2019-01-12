package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.ClassState;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class ClassStateConverter implements AttributeConverter<ClassState, Integer> {
    @Override
    public Integer convertToDatabaseColumn(ClassState attribute) {
        return attribute.value();
    }

    @Override
    public ClassState convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return ClassState.valueOf(dbData);
    }
}
