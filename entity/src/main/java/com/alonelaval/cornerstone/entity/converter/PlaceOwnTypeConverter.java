package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.PlaceOwnType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class PlaceOwnTypeConverter implements AttributeConverter<PlaceOwnType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(PlaceOwnType attribute) {
        return attribute.value();
    }

    @Override
    public PlaceOwnType convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return PlaceOwnType.valueOf(dbData);
    }
}
