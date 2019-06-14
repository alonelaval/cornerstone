package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.PermissionType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class PermissionTypeConverter implements AttributeConverter<PermissionType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(PermissionType attribute) {
        return attribute.value();
    }

    @Override
    public PermissionType convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return PermissionType.valueOf(dbData);
    }
}
