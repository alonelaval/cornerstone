package com.alonelaval.cornerstone.web.common;

import com.alonelaval.common.entity.IEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;
import org.springframework.util.NumberUtils;

import java.util.Collections;
import java.util.Set;

/**
 * @author huawei
 * @create 2018-07-27
 **/
public class StringToEnumValueConverter implements ConditionalGenericConverter {

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new ConvertiblePair(String.class,IEnum.class));
    }


    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if(source == null || StringUtils.isBlank(source.toString())){
            return  null;
        }

        if(!StringUtils.isNumeric(source.toString())) {
            return null;
        }
        try {
            return  resolveCustomEnum(NumberUtils.parseNumber(source.toString(),Integer.class), (Class<IEnum>) targetType.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private IEnum resolveCustomEnum(Integer value, Class<IEnum> type) {
        for (IEnum constant : type.getEnumConstants()){
            if (constant.value() == value) {
                return constant;
            }
        }
        return null;
    }


    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        if(targetType.getType().isEnum() && IEnum.class.isAssignableFrom(targetType.getType())) {
            return true;
        }
        return  false;

    }
}
