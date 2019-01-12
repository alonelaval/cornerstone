package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.EmployeeState;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class EmployeeStateConverter implements AttributeConverter<EmployeeState, Integer> {
    @Override
    public Integer convertToDatabaseColumn(EmployeeState attribute) {
        return attribute.value();
    }

    @Override
    public EmployeeState convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return EmployeeState.valueOf(dbData);
    }
}
