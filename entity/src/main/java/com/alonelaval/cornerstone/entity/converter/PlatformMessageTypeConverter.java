package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.PlatformMessageType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class PlatformMessageTypeConverter implements AttributeConverter<PlatformMessageType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(PlatformMessageType attribute) {
        return attribute.value();
    }

    @Override
    public PlatformMessageType convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return PlatformMessageType.valueOf(dbData);
    }
}
