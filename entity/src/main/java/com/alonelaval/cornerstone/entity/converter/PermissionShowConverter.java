package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.PermissionShow;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class PermissionShowConverter implements AttributeConverter<PermissionShow, Integer> {
    @Override
    public Integer convertToDatabaseColumn(PermissionShow attribute) {
        return attribute.value();
    }

    @Override
    public PermissionShow convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return PermissionShow.valueOf(dbData);
    }
}
