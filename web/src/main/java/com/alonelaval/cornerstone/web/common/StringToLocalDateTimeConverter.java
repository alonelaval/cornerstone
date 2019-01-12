package com.alonelaval.cornerstone.web.common;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Set;

/**
 * @author huawei
 * @create 2018-07-27
 **/
public class StringToLocalDateTimeConverter implements ConditionalGenericConverter {

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new ConvertiblePair(String.class,LocalDateTime.class));
    }


    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if(source == null || StringUtils.isBlank(source.toString())){
            return  null;
        }

        try {
            return  resolveCustom(source.toString(), (Class<LocalDateTime>) targetType.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private LocalDateTime resolveCustom(String value, Class<LocalDateTime> type) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(value, formatter);
    }


    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        if(LocalDateTime.class.getName().equals(targetType.getType().getName())) {
            return true;
        }
        return  false;

    }
}
