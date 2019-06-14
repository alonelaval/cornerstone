package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.EduBackground;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class EduBackgroundConverter implements AttributeConverter<EduBackground, Integer> {
    @Override
    public Integer convertToDatabaseColumn(EduBackground attribute) {
        return attribute.value();
    }

    @Override
    public EduBackground convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return EduBackground.valueOf(dbData);
    }
}
