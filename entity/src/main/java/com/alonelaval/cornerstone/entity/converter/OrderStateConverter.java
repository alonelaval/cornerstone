package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.OrderState;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class OrderStateConverter implements AttributeConverter<OrderState, Integer> {
    @Override
    public Integer convertToDatabaseColumn(OrderState attribute) {
        return attribute.value();
    }

    @Override
    public OrderState convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return OrderState.valueOf(dbData);
    }
}
