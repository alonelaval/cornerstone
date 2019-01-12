package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.PayType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class PayTypeConverter implements AttributeConverter<PayType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(PayType attribute) {
        return attribute.value();
    }

    @Override
    public PayType convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return PayType.valueOf(dbData);
    }
}
