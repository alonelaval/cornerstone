package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.MessageSendType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class MessageSendTypeConverter implements AttributeConverter<MessageSendType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(MessageSendType attribute) {
        return attribute.value();
    }

    @Override
    public MessageSendType convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return MessageSendType.valueOf(dbData);
    }
}
