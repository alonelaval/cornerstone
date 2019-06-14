package com.alonelaval.cornerstone.web.common;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Set;

/**
 * @author huawei
 * @create 2018-07-27
 **/
public class StringToLocalDateConverter implements ConditionalGenericConverter {

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new ConvertiblePair(String.class,LocalDate.class));
    }


    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if(source == null || StringUtils.isBlank(source.toString())){
            return  null;
        }

        try {
            return  resolveCustom(source.toString(), (Class<LocalDate>) targetType.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private LocalDate resolveCustom(String value, Class<LocalDate> type) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(value, formatter);
    }


    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        if(LocalDate.class.getName().equals(targetType.getType().getName())) {
            return true;
        }
        return  false;

    }
}
