package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.MessageType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class MessageTypeConverter implements AttributeConverter<MessageType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(MessageType attribute) {
        return attribute.value();
    }

    @Override
    public MessageType convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return MessageType.valueOf(dbData);
    }
}
