package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.IsArrangeClass;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class IsArrangeClassConverter implements AttributeConverter<IsArrangeClass, Integer> {
    @Override
    public Integer convertToDatabaseColumn(IsArrangeClass attribute) {
        return attribute.value();
    }

    @Override
    public IsArrangeClass convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return IsArrangeClass.valueOf(dbData);
    }
}
