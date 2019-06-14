package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.AdminDivision;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class AdminDivisionConverter implements AttributeConverter<AdminDivision, Integer> {
    @Override
    public Integer convertToDatabaseColumn(AdminDivision attribute) {
        return attribute.value();
    }

    @Override
    public AdminDivision convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return AdminDivision.valueOf(dbData);
    }
}
