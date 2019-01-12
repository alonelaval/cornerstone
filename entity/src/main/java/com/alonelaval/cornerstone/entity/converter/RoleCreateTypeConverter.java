package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.RoleCreateType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class RoleCreateTypeConverter implements AttributeConverter<RoleCreateType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(RoleCreateType attribute) {
        return attribute.value();
    }

    @Override
    public RoleCreateType convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return RoleCreateType.valueOf(dbData);
    }
}
