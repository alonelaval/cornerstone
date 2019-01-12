package com.alonelaval.cornerstone.web.common;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Set;

/**
 * @author huawei
 * @create 2018-07-27
 **/
public class StringToLocalTimeConverter implements ConditionalGenericConverter {

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new ConvertiblePair(String.class,LocalTime.class));
    }


    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if(source == null || StringUtils.isBlank(source.toString())){
            return  null;
        }

        try {
            return  resolveCustom(source.toString(), (Class<LocalTime>) targetType.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private LocalTime resolveCustom(String value, Class<LocalTime> type) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(value, formatter);
    }


    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        if(LocalTime.class.getName().equals(targetType.getType().getName())) {
            return true;
        }
        return  false;

    }
}
