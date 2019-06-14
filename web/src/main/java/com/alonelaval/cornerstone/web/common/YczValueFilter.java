package com.alonelaval.cornerstone.web.common;

import com.alibaba.fastjson.serializer.ValueFilter;
import com.alonelaval.common.entity.IEnum;
import com.alonelaval.common.security.IDSecurityUtils;
import com.alonelaval.cornerstone.web.config.ApplicationConfig;
import com.alonelaval.cornerstone.web.config.ApplicationConfig;

/**
 * @author huawei
 * @create 2018-07-22
 * 对所有ID进行加密，出口JSON数据
 **/
public class YczValueFilter implements ValueFilter {
    private ApplicationConfig config;
    private static  final  String ID = "ID";

    public YczValueFilter(ApplicationConfig config) {
        this.config = config;
    }

    @Override
    public Object process(Object object, String name, Object value) {
        if(value != null && value instanceof IEnum){
            IEnum iEnum = (IEnum) value;
            return  iEnum.value();
        }
        if((name.endsWith(ID) || name.toUpperCase().endsWith(ID)) && value != null){
            return IDSecurityUtils.encId(value.toString(),config.getIdSecret());
        }

        return value;
    }
}
