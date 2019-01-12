package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.OrgState;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class OrgStateConverter implements AttributeConverter<OrgState, Integer> {
    @Override
    public Integer convertToDatabaseColumn(OrgState attribute) {
        return attribute.value();
    }

    @Override
    public OrgState convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return OrgState.valueOf(dbData);
    }
}
