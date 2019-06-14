package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.ProductVersion;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class ProductVersionConverter implements AttributeConverter<ProductVersion, Integer> {
    @Override
    public Integer convertToDatabaseColumn(ProductVersion attribute) {
        return attribute.value();
    }

    @Override
    public ProductVersion convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return ProductVersion.valueOf(dbData);
    }
}
