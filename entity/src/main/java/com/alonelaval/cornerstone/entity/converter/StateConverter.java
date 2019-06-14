package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.State;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class StateConverter implements AttributeConverter<State, Integer> {
    @Override
    public Integer convertToDatabaseColumn(State attribute) {
        return attribute.value();
    }

    @Override
    public State convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return State.valueOf(dbData);
    }
}
