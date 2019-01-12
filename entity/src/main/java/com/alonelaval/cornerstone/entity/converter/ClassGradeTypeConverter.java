package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.ClassGradeType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class ClassGradeTypeConverter implements AttributeConverter<ClassGradeType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(ClassGradeType attribute) {
        return attribute.value();
    }

    @Override
    public ClassGradeType convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return ClassGradeType.valueOf(dbData);
    }
}
