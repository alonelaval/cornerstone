package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.AllowUserSettingCourseTimeType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class AllowUserSettingCourseTimeTypeConverter implements AttributeConverter<AllowUserSettingCourseTimeType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(AllowUserSettingCourseTimeType attribute) {
        return attribute.value();
    }

    @Override
    public AllowUserSettingCourseTimeType convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return AllowUserSettingCourseTimeType.valueOf(dbData);
    }
}
