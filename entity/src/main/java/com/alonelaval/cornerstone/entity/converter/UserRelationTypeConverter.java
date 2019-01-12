package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.UserRelationType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class UserRelationTypeConverter implements AttributeConverter<UserRelationType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(UserRelationType attribute) {
        return attribute.value();
    }

    @Override
    public UserRelationType convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return UserRelationType.valueOf(dbData);
    }
}
