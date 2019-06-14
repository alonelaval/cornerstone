package com.alonelaval.cornerstone.web.common;

import com.alonelaval.common.security.IDSecurityUtils;
import com.alonelaval.cornerstone.web.config.ApplicationConfig;
import com.alonelaval.cornerstone.web.config.ApplicationConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

/**
 * @author huawei
 * @create 2018-07-24
 **/
public class IDSecurityConverter implements Converter<String,Integer>  {

    ApplicationConfig applicationConfig;
    public IDSecurityConverter(ApplicationConfig applicationConfig)
    {
        this.applicationConfig = applicationConfig;
    }
    @Override
    public Integer convert(String source) {

        if(StringUtils.isBlank(source)) {
            return null;
        }
        if(StringUtils.isNumeric(source)){
            return  Integer.parseInt(source);
        }

        return Integer.parseInt(IDSecurityUtils.decId(source,applicationConfig.getIdSecret()));
    }
}
