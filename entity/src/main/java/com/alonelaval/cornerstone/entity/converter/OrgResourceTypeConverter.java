package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.OrgResourceType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class OrgResourceTypeConverter implements AttributeConverter<OrgResourceType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(OrgResourceType attribute) {
        return attribute.value();
    }

    @Override
    public OrgResourceType convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return OrgResourceType.valueOf(dbData);
    }
}
