package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.CheckinType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class CheckinTypeConverter implements AttributeConverter<CheckinType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(CheckinType attribute) {
        return attribute.value();
    }

    @Override
    public CheckinType convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return CheckinType.valueOf(dbData);
    }
}
