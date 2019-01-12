package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.RoleOwnType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class RoleOwnTypeConverter implements AttributeConverter<RoleOwnType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(RoleOwnType attribute) {
        return attribute.value();
    }

    @Override
    public RoleOwnType convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return RoleOwnType.valueOf(dbData);
    }
}
