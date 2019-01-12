package com.alonelaval.cornerstone.web.common;

import com.alibaba.fastjson.serializer.ValueFilter;
import com.alonelaval.common.entity.IEnum;


/**
 * @author huawei
 * @create 2018-07-27
 * @deprecated 参与yczValueFilter
 **/
public class EnumValueFilter  implements ValueFilter {
    @Override
    public Object process(Object object, String name, Object value) {
        if(value != null && value instanceof IEnum){

            IEnum iEnum = (IEnum) value;
            return  iEnum.value();
        }

        return value;
    }
}
