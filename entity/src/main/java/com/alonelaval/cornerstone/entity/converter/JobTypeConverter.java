package com.alonelaval.cornerstone.entity.converter;

import com.alonelaval.cornerstone.entity.constants.JobType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author huawei
 * @create 2018-07-28
 **/
@Converter(autoApply = true)
public class JobTypeConverter implements AttributeConverter<JobType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(JobType attribute) {
        return attribute.value();
    }

    @Override
    public JobType convertToEntityAttribute(Integer dbData) {
    	if(dbData == null) {
            return null;
        }
        return JobType.valueOf(dbData);
    }
}
