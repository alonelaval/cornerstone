package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.AuditState;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class AuditStateConverter implements AttributeConverter<AuditState, Integer> {
    @Override
    public Integer convertToDatabaseColumn(AuditState attribute) {
        return attribute.value();
    }

    @Override
    public AuditState convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return AuditState.valueOf(dbData);
    }
}
