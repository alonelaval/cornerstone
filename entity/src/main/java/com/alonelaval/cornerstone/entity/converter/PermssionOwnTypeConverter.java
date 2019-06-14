package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.PermssionOwnType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class PermssionOwnTypeConverter implements AttributeConverter<PermssionOwnType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(PermssionOwnType attribute) {
        return attribute.value();
    }

    @Override
    public PermssionOwnType convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return PermssionOwnType.valueOf(dbData);
    }
}
