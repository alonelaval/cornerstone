package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.MessageRuleType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class MessageRuleTypeConverter implements AttributeConverter<MessageRuleType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(MessageRuleType attribute) {
        return attribute.value();
    }

    @Override
    public MessageRuleType convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return MessageRuleType.valueOf(dbData);
    }
}
