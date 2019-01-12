package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.MessageSendChannel;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class MessageSendChannelConverter implements AttributeConverter<MessageSendChannel, Integer> {
    @Override
    public Integer convertToDatabaseColumn(MessageSendChannel attribute) {
        return attribute.value();
    }

    @Override
    public MessageSendChannel convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return MessageSendChannel.valueOf(dbData);
    }
}
