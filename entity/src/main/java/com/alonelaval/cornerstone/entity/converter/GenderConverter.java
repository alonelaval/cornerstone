package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.Gender;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<Gender, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Gender attribute) {
        return attribute.value();
    }

    @Override
    public Gender convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return Gender.valueOf(dbData);
    }
}
