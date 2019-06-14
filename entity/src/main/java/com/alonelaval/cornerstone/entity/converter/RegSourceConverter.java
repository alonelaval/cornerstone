package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.RegSource;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class RegSourceConverter implements AttributeConverter<RegSource, Integer> {
    @Override
    public Integer convertToDatabaseColumn(RegSource attribute) {
        return attribute.value();
    }

    @Override
    public RegSource convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return RegSource.valueOf(dbData);
    }
}
