package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.OrderType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class OrderTypeConverter implements AttributeConverter<OrderType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(OrderType attribute) {
        return attribute.value();
    }

    @Override
    public OrderType convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return OrderType.valueOf(dbData);
    }
}
