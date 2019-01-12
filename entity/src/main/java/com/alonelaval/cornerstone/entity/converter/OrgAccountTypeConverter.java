package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.OrgAccountType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class OrgAccountTypeConverter implements AttributeConverter<OrgAccountType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(OrgAccountType attribute) {
        return attribute.value();
    }

    @Override
    public OrgAccountType convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return OrgAccountType.valueOf(dbData);
    }
}
