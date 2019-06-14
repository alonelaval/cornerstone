package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.ExceptionType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class ExceptionTypeConverter implements AttributeConverter<ExceptionType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(ExceptionType attribute) {
        return attribute.value();
    }

    @Override
    public ExceptionType convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return ExceptionType.valueOf(dbData);
    }
}
