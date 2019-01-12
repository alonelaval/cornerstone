package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.VisitType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class VisitTypeConverter implements AttributeConverter<VisitType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(VisitType attribute) {
        return attribute.value();
    }

    @Override
    public VisitType convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return VisitType.valueOf(dbData);
    }
}
